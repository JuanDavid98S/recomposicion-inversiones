import { Component, OnInit } from '@angular/core';
import { AutenticacionService } from './autenticacion.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-form-autenticacion',
  templateUrl: './form-autenticacion.component.html',
  styleUrls: ['./form-autenticacion.component.css']
})
export class FormAutenticacionComponent implements OnInit {

  usuarios : Usuario[];
  admins : Usuario[];

  constructor(private servicioAutenticacion : AutenticacionService) { }

  ngOnInit(): void {
    this.servicioAutenticacion.listarUsuarios().subscribe(
      usuario => {
        this.usuarios = usuario
      }
    );
  }

  listarAdministradores(){
    this.servicioAutenticacion.listarAdmins().subscribe(
      admin => {
        this.admins = admin
      }
    );
  }
  

}
