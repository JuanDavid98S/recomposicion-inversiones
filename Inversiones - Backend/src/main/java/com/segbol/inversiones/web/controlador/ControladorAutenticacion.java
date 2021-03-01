package com.segbol.inversiones.web.controlador;

import com.segbol.inversiones.dominio.servicio.IServicioAutenticacion;
import com.segbol.inversiones.persistencia.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/autenticacion")
public class ControladorAutenticacion {

    //Interfaz para servicio de autenticación
    @Autowired
    IServicioAutenticacion servicioAutenticacion;

    //Lista los usuarios almacenados en la base de datos
    @GetMapping("/usuarios")
    public ResponseEntity<ArrayList<Usuario>> listarUsuarios(){
        return ResponseEntity.ok().body(servicioAutenticacion.listarUsuarios());
    }

    //Lista los usuarios de tipo administrador en la base de datos
    @GetMapping("/admins")
    public ResponseEntity<ArrayList<Usuario>> listarAdmins(){
        return ResponseEntity.ok().body(servicioAutenticacion.listarAdmins());
    }

    //Recupera la información de un usuario con su identificador
    @GetMapping("/sesion/{idUsuario}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer idUsuario){

        return ResponseEntity.ok().body(servicioAutenticacion.obtenerUsuario(idUsuario));
    }
}
