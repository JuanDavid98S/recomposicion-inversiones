package com.segbol.inversiones.dominio.servicio;

import com.segbol.inversiones.dominio.repositorio.RepositorioPortafolios;
import com.segbol.inversiones.persistencia.entidades.Portafolio;
import com.segbol.inversiones.persistencia.entidades.PortafolioCiudad;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class ServicioPortafolio implements IServicioPortafolio{

    @Autowired
    RepositorioPortafolios repositorioPortafolios;

    /**
     * @param idUsuario Identificador único del usuario
     * @return ArrayList de Portafolio con los portafolios que tiene activos el usuario
     */
    @Override
    public ArrayList<PortafoliosUsuario> mostrarPortafoliosUsuario(Integer idUsuario) {
        return repositorioPortafolios.mostrarPortafoliosUsuario(idUsuario);
    }

    /**
     * @param idUsuario Identificador único del usuario
     * @return Muestra los portafolios disponibles al usuario según filtros definidos en los mismos
     */
    @Override
    public ArrayList<Portafolio> mostrarPortafoliosDisponibles(Integer idUsuario) {
        return repositorioPortafolios.mostrarPortafoliosDisponibles(idUsuario);
    }

    /**
     * @param idUsuario Identificador único del usuario
     * @param totalInvertido Cantidad total de dinero registrada para el usuario en la empresa
     * @param idCiudad Identificador de la ciudad a la que está asociado el usuario
     * @param ingresoEmpresa Cantidad de años que lleva el usuario en la empresa
     * @return Portafolios premium del sistema
     */
    @Override
    public ArrayList<Portafolio> mostrarPortafoliosEspeciales(Integer idUsuario, Double totalInvertido, Integer idCiudad, Integer ingresoEmpresa) {
        return repositorioPortafolios.mostrarPortafoliosEspeciales(idUsuario, totalInvertido, idCiudad, ingresoEmpresa);
    }

    /**
     * @return Devuelve la lista de todos los portafolios registrados
     */
    @Override
    public ArrayList<Portafolio> mostrarTodosPortafolios() {
        return repositorioPortafolios.mostrarTodosPortafolios();
    }

    /**
     * @param idPortafolio Identificador único del portafolio
     * @return Devuelve un portafolio utilizando su identificador único para encontrarlo
     */
    @Override
    public Portafolio verDetallesPortafolio(Integer idPortafolio) {
        return repositorioPortafolios.verDetallesPortafolio(idPortafolio);
    }

    /**
     * @param idPortafolio Identificador único del portafolio
     * @param ingresoEmpresa Cantidad de años que debe llevar un cliente en la empresa para visualizar el portafolio
     * @param inversionTotalMinima Cantidad de dinero total que debe tener un usuario invertido en la empresa
     */
    @Override
    public void cambiarCondiciones(Integer idPortafolio, Integer ingresoEmpresa, Double inversionTotalMinima) {
         repositorioPortafolios.cambiarCondiciones(idPortafolio, ingresoEmpresa, inversionTotalMinima);
    }

    /**
     * @param idPortafolio Identificador único del portafolio
     * @return Ciudades asociadas al portafolio
     */
    @Override
    public ArrayList<PortafolioCiudad> obtenerCiudades(Integer idPortafolio) {
        return repositorioPortafolios.obtenerCiudades(idPortafolio);
    }

    /**
     * @param idPortafolio Identificador único del portafolio
     * @param idCiudad Identificador único de la ciudad
     * @return id de registro en la tabla portafolio_ciudad si la inserción es exitosa
     */
    @Override
    public BigDecimal actualizarCiudad(Integer idPortafolio, Integer idCiudad) {
        return repositorioPortafolios.actualizarCiudad(idPortafolio, idCiudad);
    }

}
