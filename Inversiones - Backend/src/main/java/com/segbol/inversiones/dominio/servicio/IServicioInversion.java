package com.segbol.inversiones.dominio.servicio;

import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;

//Interfaz para la definición de métodos abstractos de la clase
public interface IServicioInversion {
    PortafoliosUsuario obtenerInversion(Integer idUsuarioPortafolio);
    void recomponerInversion(Integer idUsuario, Integer idPortafolio, Double montoInvertivo);
    void activarPortafolios(Integer idUsuario, Integer idPortafolio);
    Integer obtenerTiempoActivacion(Integer idPortafolio);
}
