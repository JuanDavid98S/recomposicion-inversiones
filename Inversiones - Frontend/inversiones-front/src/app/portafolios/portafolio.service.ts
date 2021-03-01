import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Portafolio } from './portafolio';
import { PortafolioCiudades } from './portafolioCiudades';
import { PortafolioUsuario } from './portafolioUsuario';

@Injectable({
  providedIn: 'root'
})
export class PortafolioService {

  private url : string = "http://localhost:8090/api/portafolios";

  constructor(private http: HttpClient) { }


  //Obtener los portafolios
  listarPortafolios(): Observable<Portafolio[]>{
    return this.http.get<Portafolio[]>(this.url+'/todos');
  }

  //Obtener un portafolio
  obtenerPortafolio(idPortafolio: number): Observable<Portafolio>{
    return this.http.get<Portafolio>(this.url +'/detalles/'+ idPortafolio);
  }

  //Obtener ciudades del portafolio
  obtenerCiudades(idPortafolio: number): Observable<PortafolioCiudades[]>{
    return this.http.get<PortafolioCiudades[]>(this.url + '/ciudades/' + idPortafolio);
  }

  //Actualizar condiciones portafolio
  cambiarCondicionesPortafolio(portafolio: Portafolio): Observable<Portafolio>{
    return this.http.put<Portafolio>(this.url+'/actualizar', portafolio);
  } 

  //Obtener portafolios de un usuario
  obtenerPortafoliosUsuario(idUsuario: number): Observable<PortafolioUsuario[]>{
    return this.http.get<PortafolioUsuario[]>(this.url+'/usuario/' + idUsuario);
  }

  obtenerDisponibles(idUsuario: number):Observable<Portafolio[]>{
    return this.http.get<Portafolio[]>(this.url + '/disponibles/' + idUsuario);
  }

}
