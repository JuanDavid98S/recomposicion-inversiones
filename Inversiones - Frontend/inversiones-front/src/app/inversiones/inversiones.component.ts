import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PortafolioService } from '../portafolios/portafolio.service';
import { PortafolioUsuario } from '../portafolios/portafolioUsuario';
import { InversionesService } from './inversiones.service';
import { Portafolio } from './../portafolios/portafolio';
import { inversiones } from './inversiones';

@Component({
  selector: 'app-inversiones',
  templateUrl: './inversiones.component.html',
  styleUrls: ['./inversiones.component.css']
})
export class InversionesComponent implements OnInit {

  constructor(private servicioInversion: InversionesService, 
    private servicioPortafolio: PortafolioService, 
    private rutaActiva: ActivatedRoute) { }

  inversion : PortafolioUsuario;
  porcentaje : boolean = false;
  entero : boolean = false;
  ingresoDatos : boolean = false;
  portafolios : Portafolio[];
  inversiones : inversiones[];
  

  ngOnInit(): void {
    this.cargarDatosInversion();
  }

  cargarDatosInversion(): void{
    this.rutaActiva.params.subscribe(
      e => {
        let idUsuarioPortafolio = e['idUsuarioPortafolio'];
        this.servicioInversion.obtenerInversion(idUsuarioPortafolio).subscribe(
          inv => this.inversion = inv
        );
      }
    )
  }

  cargarPortafoliosDisponibles(idUsuario: number): void{
    this.servicioPortafolio.obtenerDisponibles(idUsuario).subscribe(
      portafolio => this.portafolios = portafolio
    );
  }

  setValorActualEntero(valor : number): void{
    this.inversion.montoInvertido -= valor;
  }

  setValorActualPorcentaje(valor : number): void{
    this.inversion.montoInvertido -= (valor/100 * this.inversion.montoInvertido);
  }

  cargaInversion(idUsuario : number, idPortafolio: number, monto : number): void{
    let inversion : inversiones;
    inversion.idUsuario = idUsuario;
    inversion.idPortafolio = idPortafolio;
    inversion.montoInvertido = monto

    this.inversiones.push(inversion);
  }

}
