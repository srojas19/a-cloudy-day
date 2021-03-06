/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.sisteam.parquio.ejbs;


import co.edu.uniandes.sisteam.parquio.api.IReservaLogic;
import co.edu.uniandes.sisteam.parquio.api.IParqueaderoLogic;
import co.edu.uniandes.sisteam.parquio.api.IParqueaderoLogic;
import co.edu.uniandes.sisteam.parquio.entities.ReservaEntity;
import co.edu.uniandes.sisteam.parquio.entities.ParqueaderoEntity;
import co.edu.uniandes.sisteam.parquio.entities.ParqueaderoEntity;
import co.edu.uniandes.sisteam.parquio.persistence.ReservaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Stateless
public class ReservaLogic implements IReservaLogic {

    @Inject
    private ReservaPersistence persistence;

    @Inject
    private IParqueaderoLogic parqueaderoLogic;
    
    /**
     * Obtiene la lista de los registros de Reserva que pertenecen a una
     * Parqueadero.
     *
     * @param parqueaderoid id de la Parqueadero la cual es padre de las Reservas.
     * @return Colección de objetos de ReservaEntity.
     *
     */
    public List<ReservaEntity> getReservasParqueadero(Long parqueaderoid) {
        ParqueaderoEntity parqueadero = parqueaderoLogic.getParqueaderoId(parqueaderoid);
        return parqueadero.getReservas();
    }
    
    
    public List<ReservaEntity> getReservasConductor(int idConductor) {
        return persistence.findAllForConductor(idConductor);
    }

    /**
     * Obtiene los datos de una instancia de Reserva a partir de su ID.
     *
     * @param reservaId Identificador de la Reserva a consultar
     * @return Instancia de ReservaEntity con los datos de la Reserva
     * consultada.
     *
     */
    @Override
    public ReservaEntity getReserva(Long reservaId) {
        try {
            return persistence.find(reservaId);
        } catch (NoResultException e) {
            throw new IllegalArgumentException("La Reserva no existe");
        }
    }

    /**
     * Se encarga de crear una Reserva en la base de datos.
     *
     * @param entity Objeto de ReservaEntity con los datos nuevos
     * @param parqueaderoid id de la Parqueadero la cual sera padre de la nueva Reserva.
     * @return Objeto de ReservaEntity con los datos nuevos y su ID.
     *
     */
    @Override
    public ReservaEntity createReserva(Long parqueaderoid, ReservaEntity entity) {
        ParqueaderoEntity parqueadero = parqueaderoLogic.getParqueaderoId(parqueaderoid);
        parqueadero.add(entity);
        entity.setParqueadero(parqueadero);
        entity = persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Reserva.
     *
     * @param entity Instancia de ReservaEntity con los nuevos datos.
     * @param parqueaderoid id de la Parqueadero la  cual sera padre de la Reserva
     * actualizada.
     * @return Instancia de ReservaEntity con los datos actualizados.
     *
     */
    @Override
    public ReservaEntity updateReserva(Long parqueaderoid, ReservaEntity entity) {
        ParqueaderoEntity parqueadero = parqueaderoLogic.getParqueaderoId(parqueaderoid);
        entity.setParqueadero(parqueadero);
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Reserva de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param parqueaderoid id de la Parqueadero la cual es padre de la Reserva.
     *
     */
    @Override
    public void deleteReserva(Long id) {
        ReservaEntity old = getReserva(id);
        persistence.delete(old.getId());
    }
}
