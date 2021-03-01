package com.segbol.inversiones.dominio.servicio;

import com.segbol.inversiones.dominio.repositorio.RepositorioInversion;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioInversion implements IServicioInversion{

    @Autowired
    RepositorioInversion repositorioInversion;

    /**
     * @param idUsuarioPortafolio Identificador único de la inversión
     * @return Datos de portafolio y usuario, incluye el monto invertido y los identificadores de cada entidad
     */
    @Override
    public PortafoliosUsuario obtenerInversion(Integer idUsuarioPortafolio) {
        return repositorioInversion.obtenerInversion(idUsuarioPortafolio);
    }

    /**
     * @param idUsuario Identificador único usuario
     * @param idPortafolio Identificador único Portafolio
     * @param montoInvertivo Cantidad de dinero indicada a invertir en el portafolio
     */
    @Override
    public void recomponerInversion(Integer idUsuario, Integer idPortafolio, Double montoInvertivo) {
        repositorioInversion.recomponerInversion(idUsuario, idPortafolio, montoInvertivo);
    }

    /**
     * @param idUsuario Identificador único usuario
     * @param idPortafolio Identificador único Portafolio
     */
    @Override
    public void activarPortafolios(Integer idUsuario, Integer idPortafolio) {
        repositorioInversion.activarPortafolios(idUsuario, idPortafolio);
    }

    /**
     * @param idPortafolio Identificador único Portafolio
     * @return Días de activación para el portafolio en cuestión
     */
    @Override
    public Integer obtenerTiempoActivacion(Integer idPortafolio) {
        return repositorioInversion.obtenerTiempoActivacion(idPortafolio);
    }
}
