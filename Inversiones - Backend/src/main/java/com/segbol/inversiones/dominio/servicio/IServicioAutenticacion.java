package com.segbol.inversiones.dominio.servicio;

import com.segbol.inversiones.persistencia.entidades.Usuario;

import java.util.ArrayList;

//Interfaz para declaración de los métodos abstractos del servicio
public interface IServicioAutenticacion {
    Usuario obtenerUsuario(Integer idUsuario);
    ArrayList<Usuario> listarUsuarios();
    ArrayList<Usuario> listarAdmins();
}
