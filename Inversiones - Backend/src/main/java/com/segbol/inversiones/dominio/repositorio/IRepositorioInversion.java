package com.segbol.inversiones.dominio.repositorio;

import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;

//Interfaz que define los métodos del repositorio de inversiones
public interface IRepositorioInversion {
    PortafoliosUsuario obtenerInversion(Integer idUsuarioPortafolio);
    void recomponerInversion(Integer idUsuario, Integer idPortafolio, Double montoInvertido);
    void activarPortafolios(Integer idUsuario, Integer idPortafolio);
    Integer obtenerTiempoActivacion(Integer idPortafolio);
}
