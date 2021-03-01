package com.segbol.inversiones.web.controlador;

import com.segbol.inversiones.dominio.servicio.IServicioPortafolio;
import com.segbol.inversiones.persistencia.entidades.Portafolio;
import com.segbol.inversiones.persistencia.entidades.PortafolioCiudad;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@RequestMapping("api/portafolios")
public class ControladorPortafolio {
    @Autowired
    IServicioPortafolio servicioPortafolio;

    //Devuelve todos los portafolios registrados en el sistema
    @GetMapping("/todos")
    public ResponseEntity<ArrayList<Portafolio>> mostrarTodosPortafolios(){
        return ResponseEntity.ok().body(servicioPortafolio.mostrarTodosPortafolios());
    }

    //Recupera la información de un portafolio con su identificador
    @GetMapping("/detalles/{idPortafolio}")
    public ResponseEntity<Portafolio> verDetallesPortafolio(@PathVariable("idPortafolio") Integer idPortafolio){
        return  ResponseEntity.ok().body(servicioPortafolio.verDetallesPortafolio(idPortafolio));
    }

    //Recupera los portafolios disponibles para inversión del usuario
    //Filtra los portafolios que no se hayan gestionado para el usuario
    @GetMapping("/disponibles/{idUsuario}")
    public ResponseEntity<ArrayList<Portafolio>> mostrarPortafoliosDisponibles(@PathVariable(value = "idUsuario") Integer idUsuario){
        return ResponseEntity.ok().body(servicioPortafolio.mostrarPortafoliosDisponibles(idUsuario));
    }

    //Muestra los portafolios en los que el usuario ha realizado una inversión
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<ArrayList<PortafoliosUsuario>> mostrarPortafoliosUsuario(@PathVariable(value = "idUsuario") Integer idUsuario){
        return ResponseEntity.ok().body(servicioPortafolio.mostrarPortafoliosUsuario(idUsuario));
    }

    //Filtra los portafolios premium dependiendo de las condiciones relacionadas
    @GetMapping("/premium/{idUsuario}")
    public ResponseEntity<ArrayList<Portafolio>> mostrarPortafoliosEspeciales(@PathVariable Integer idUsuario,
                                                         @RequestParam(value = "totalInvertido") Double totalInvertido,
                                                         @RequestParam(value = "idCiudad") Integer idCiudad,
                                                         @RequestParam(value = "ingresoEmpresa") Integer ingresoEmpresa){
        return ResponseEntity.ok().body(servicioPortafolio.mostrarPortafoliosEspeciales(idUsuario, totalInvertido, idCiudad, ingresoEmpresa));
    }

    //Actualiza el valor fecha de ingreso a la empresa e inversión total mínima requerida en la empresa
    @PutMapping("/actualizar")
    public void cambiarCondiciones(@RequestBody Portafolio portafolio){
        servicioPortafolio.cambiarCondiciones(
                portafolio.getIdPortafolio(),
                portafolio.getIngresoEmpresa(),
                portafolio.getInversionTotalMinima()
        );
    }

    //Recupera las ciudades en las que está actualmente disponible el portafolio
    @GetMapping("/ciudades/{idPortafolio}")
    public ResponseEntity<ArrayList<PortafolioCiudad>> obtenerCiudades(@PathVariable Integer idPortafolio){
        System.out.println("\n mostrando ciudades");
        return ResponseEntity.ok().body(servicioPortafolio.obtenerCiudades(idPortafolio));
    }

    //Actualiza las ciudades en las que estará disponible el portafolio
    @PostMapping("/ciudades")
    public ResponseEntity<BigDecimal> actualizarCiudad(@RequestBody PortafolioCiudad portafolioCiudad){
        return ResponseEntity.ok().body(servicioPortafolio.actualizarCiudad(
                portafolioCiudad.getIdPortafolio(),
                portafolioCiudad.getIdCiudad()));
    }
}
