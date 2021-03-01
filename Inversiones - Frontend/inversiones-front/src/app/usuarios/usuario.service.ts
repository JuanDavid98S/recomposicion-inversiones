import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../form-autenticacion/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url : string = "http://localhost:8090/api/autenticacion";

  constructor(private http: HttpClient) { }

  //Autenticar usuario
  autenticarUsuario(idUsuario: number): Observable<Usuario>{
    return this.http.get<Usuario>(this.url + '/sesion/' + idUsuario);
  }
}
