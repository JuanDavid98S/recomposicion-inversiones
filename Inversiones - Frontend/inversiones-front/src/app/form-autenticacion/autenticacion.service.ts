import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  private url : string = "http://localhost:8090/api/autenticacion";

  constructor(private http: HttpClient) { }

  listarUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url+'/usuarios');
  }

  listarAdmins(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url+'/admins');
  }
}
