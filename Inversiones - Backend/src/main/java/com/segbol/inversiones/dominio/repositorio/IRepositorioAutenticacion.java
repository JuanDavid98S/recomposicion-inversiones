package com.segbol.inversiones.dominio.repositorio;

import com.segbol.inversiones.persistencia.entidades.Usuario;

import java.util.ArrayList;

//Interfaz para definir los métodos abstractos del repositorio de autenticación
public interface IRepositorioAutenticacion {
    Usuario obtenerUsuario(Integer idUsuario);
    ArrayList<Usuario> listarUsuarios();
    ArrayList<Usuario> listarAdmins();
}
