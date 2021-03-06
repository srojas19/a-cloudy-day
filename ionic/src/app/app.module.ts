import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { IonicStorageModule } from '@ionic/storage';
import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { DetailPage } from '../pages/detail/detail';
import {DetVehiculo} from '../pages/det-vehiculo/det-vehiculo';
import { Geolocation } from '@ionic-native/geolocation';
import { InicioPerfil } from '../pages/inicio-perfil/inicio-perfil';
import { DetalleReserva } from '../pages/detalle-reserva/detalle-reserva';
import {AgregarFavorito} from '../pages/agregarfavorito/agregarfavorito';
import {InfoReserva} from '../pages/inforeserva/inforeserva';


@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    DetailPage,
    DetVehiculo,
    InicioPerfil,
    DetalleReserva,
    AgregarFavorito,
    InfoReserva
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    DetailPage,
    DetVehiculo,
    InicioPerfil,
    DetalleReserva,
    AgregarFavorito,
    InfoReserva
  ],
  providers: [
    Geolocation,
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
