import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../form-autenticacion/usuario';
import { Portafolio } from '../portafolios/portafolio';
import { PortafolioService } from './../portafolios/portafolio.service';
import { UsuarioService } from './usuario.service';
import { PortafolioUsuario } from './../portafolios/portafolioUsuario';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuario : Usuario;
  portafolios : Portafolio[];
  portafoliosUsuario : PortafolioUsuario[];
  

  constructor(private portafolioService: PortafolioService, 
    private rutaActiva: ActivatedRoute, 
    private router: Router,
    private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.cargarDatosUsuario();
  }

  recomponerInversion(idPortafolio : number){
    console.log(idPortafolio);
  }

  cargarDatosUsuario(): void{
    this.rutaActiva.params.subscribe(
      e => {
        let idUsuario = e['idUsuario'];
        if(idUsuario){
          this.usuarioService.autenticarUsuario(idUsuario).subscribe(
            usua => this.usuario = usua
          );
          this.portafolioService.obtenerPortafoliosUsuario(idUsuario).subscribe(
            portafolio => this.portafoliosUsuario = portafolio
          );
        }
      }
    )
  }
}
