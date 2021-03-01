import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Portafolio } from './portafolio';
import { PortafolioService } from './portafolio.service';
import { PortafolioCiudades } from './portafolioCiudades';

@Component({
  selector: 'app-form-portafolio',
  templateUrl: './form-portafolio.component.html',
  styleUrls: ['./form-portafolio.component.css']
})
export class FormPortafolioComponent implements OnInit {

  titulo: string = "Actualización de condiciones";
  portafolio: Portafolio;
  ciudades : PortafolioCiudades[];

  constructor(private servicioPortafolio: PortafolioService, private router: Router, private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargaDatosPortafolio();
  }

  cargaDatosPortafolio(): void{
    this.rutaActiva.params.subscribe(
      e => {
        let idPortafolio = e['idPortafolio'];
        if(idPortafolio){
          this.servicioPortafolio.obtenerPortafolio(idPortafolio).subscribe(
           portaf => this.portafolio = portaf
          ); 
        }
      }
    );
  }

  obtenerCiudades(idPortafolio): void{
    this.rutaActiva.params.subscribe(
      e => {
        let idPortafolio = e['idPortafolio'];
        return this.servicioPortafolio.obtenerCiudades(idPortafolio).subscribe(
          ciudad => this.ciudades = ciudad
        );
        }
    );
  }

  //Envío de datos para actualización de condiciones en el portafolio
  actualizar(): void{
    this.servicioPortafolio.cambiarCondicionesPortafolio(this.portafolio).subscribe(
      res => this.router.navigate(['/portafolios'])
    );
  }

}
