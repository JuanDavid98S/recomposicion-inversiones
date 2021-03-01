import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { Routes, RouterModule } from '@angular/router';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PortafoliosComponent } from './portafolios/portafolios.component';
import { FormPortafolioComponent } from './portafolios/form-portafolio.component';
import { FormAutenticacionComponent } from './form-autenticacion/form-autenticacion.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { InversionesComponent } from './inversiones/inversiones.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


const routes: Routes = [
  { path:'', redirectTo:'/login', pathMatch:'full' },
  { path:'login', component: FormAutenticacionComponent},
  { path:'usuarios/sesion/:idUsuario', component: UsuariosComponent},
  { path:'usuarios/sesion/:idUsuario/inversion/:idUsuarioPortafolio', component: InversionesComponent},
  { path:'portafolios', component: PortafoliosComponent },
  { path:'portafolios/form/:idPortafolio', component: FormPortafolioComponent}
 
]

@NgModule({
  declarations: [
    AppComponent,
    PortafoliosComponent,
    FormPortafolioComponent,
    FormAutenticacionComponent,
    UsuariosComponent,
    InversionesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
