package com.segbol.inversiones.dominio.repositorio;

import com.segbol.inversiones.persistencia.entidades.Portafolio;
import com.segbol.inversiones.persistencia.entidades.PortafolioCiudad;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;

import java.math.BigDecimal;
import java.util.ArrayList;

//Interfaz para comunicación con el repositorio
public interface IRepositorioPortafolio {
     ArrayList<PortafoliosUsuario> mostrarPortafoliosUsuario(Integer idUsuario);
     ArrayList<Portafolio> mostrarPortafoliosDisponibles(Integer idUsuario);
     ArrayList<Portafolio> mostrarPortafoliosEspeciales(Integer idUsuario, Double totalInvertido, Integer idCiudad, Integer ingresoEmpresa);
     ArrayList<Portafolio> mostrarTodosPortafolios();
     Portafolio verDetallesPortafolio(Integer idPortafolio);
     void cambiarCondiciones(Integer idPortafolio, Integer ingresoEmpresa, Double inversionTotalMinima);
     ArrayList<PortafolioCiudad> obtenerCiudades(Integer idPortafolio);
     BigDecimal actualizarCiudad(Integer idPortafolio, Integer idCiudad);
}
