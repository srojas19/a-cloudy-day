/*
 * ReservaDTO
 * Objeto de transferencia de datos de Reservas.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
package co.edu.uniandes.rest.parquio.dtos;

import co.edu.uniandes.sisteam.parquio.entities.ReservaEntity;
import java.util.Date;

/**
 * Objeto de transferencia de datos de Ciudades.
 *
 * @author Asistente
 */
public class ReservaDTO {

    private Long id;

    private Date fecha;
    private double duracion;
    private int idConductor;

    /**
     * Constructor por defecto
     */
    public ReservaDTO() {
    }

    public ReservaDTO(Long id, Date fecha, double duracion, int idConductor) {
        this.id = id;
        this.fecha = fecha;
        this.duracion = duracion;
        this.idConductor = idConductor;
    }

    public ReservaDTO(ReservaEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.fecha = entity.getFecha();
            this.duracion = entity.getDuracion();
            this.idConductor = entity.getIdConductor();
        }
    }

    /**
     * Convierte un objeto ReservaDTO a ReservaEntity.
     *
     * @return Nueva objeto ReservaEntity.
     *
     */
    public ReservaEntity toEntity() {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(this.getId());
        entity.setFecha(this.getFecha());
        entity.setDuracion(this.getDuracion());
        entity.setIdConductor(this.getIdConductor());
        return entity;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    
}
