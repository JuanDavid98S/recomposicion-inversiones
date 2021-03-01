import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortafolioUsuario } from '../portafolios/portafolioUsuario';

@Injectable({
  providedIn: 'root'
})
export class InversionesService {

  private url : string = "http://localhost:8090/api/inversion";

  constructor(private http : HttpClient) { }

  //Obtener el portafolio a recomponer
  obtenerInversion(id : number): Observable<PortafolioUsuario>{
    return this.http.get<PortafolioUsuario>(this.url + '/obtener/' + id);
  }
}
