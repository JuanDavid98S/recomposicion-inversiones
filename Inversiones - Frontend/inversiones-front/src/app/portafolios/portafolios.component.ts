import { Component, OnInit } from '@angular/core';
import { Portafolio } from './portafolio';
import { PortafolioService } from './portafolio.service';

@Component({
  selector: 'app-portafolios',
  templateUrl: './portafolios.component.html',
  styleUrls: ['./portafolios.component.css']
})
export class PortafoliosComponent implements OnInit {

  portafolios : Portafolio[];
  titulo : string = 'Portafolios registrados en el sistema';

  constructor(private servicioPortafolio: PortafolioService) { }

  ngOnInit(): void {
    this.servicioPortafolio.listarPortafolios().subscribe(
      e => {
        return this.portafolios = e;
      }
    );
  }

}
