package com.segbol.inversiones.dominio.servicio;

import com.segbol.inversiones.dominio.repositorio.RepositorioAutenticacion;
import com.segbol.inversiones.persistencia.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioAutenticacion implements IServicioAutenticacion{

    @Autowired
    RepositorioAutenticacion repositorioAutenticacion;

    /**
     * @param idUsuario Identificador único del usuario
     * @return Usuario: Objeto de la clase usuario
     */
    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        return repositorioAutenticacion.obtenerUsuario(idUsuario);
    }

    /**
     * @return ArrayList Usuario: Lista de objetos de tipo usuario
     */
    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return repositorioAutenticacion.listarUsuarios();
    }

    /**
     * @return ArrayList Usuario: Lista de objetos de tipo usuario
     */
    @Override
    public ArrayList<Usuario> listarAdmins() {
        return repositorioAutenticacion.listarAdmins();
    }
}
