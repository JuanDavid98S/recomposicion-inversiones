package com.segbol.inversiones.web.controlador;

import com.segbol.inversiones.dominio.servicio.IServicioInversion;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/inversion")
public class ControladorInversion {

    //Instancia de la clase holidayUtil para definir días laborales y festivos para el año 2020
    private HolidayUtil holidayUtil = new HolidayUtil(2020);

    @Autowired
    private IServicioInversion servicioInversion;

    //Esta función devuelve la fecha en la que se debe activar el portafolio según el tiempo de activación que se le pase
    public Date obtenerFechaActivacion(@RequestParam(value = "diasActivacion") Integer diasActivacion){
        return holidayUtil.getNextBusinessDay(new Date(), diasActivacion);
    }

    //Función para obtener un objeto de tipo Portafolios Usuario, para relacionar el portafolio en el que se ha invertido con el usuario
    @GetMapping("/obtener/{idUsuarioPortafolio}")
    public ResponseEntity<PortafoliosUsuario> obtenerInversion(@PathVariable("idUsuarioPortafolio") Integer idUsuarioPortafolio){
        return ResponseEntity.ok().body(servicioInversion.obtenerInversion(idUsuarioPortafolio));
    }

    //Función para crear la inversión en la base de datos asociada con el portafolio y el usuario
    @PostMapping("/recomposicion")
    public void recomponerInversion(@RequestParam(value = "idUsuario") Integer idUsuario,
                                    @RequestParam(value = "idPortafolio") Integer idPortafolio,
                                    @RequestParam(value = "montoInvertido") Double montoInvertido){
        servicioInversion.recomponerInversion(idUsuario, idPortafolio, montoInvertido);
    }

    //Función para cambiar el estado de los portafolios en inversiones a activos ('A')
    @PostMapping("/activar-portafolio")
    public void activarPortafolio(@RequestParam(value = "idUsuario") Integer idUsuario,
                                  @RequestParam(value = "idPortafolio") Integer idPortafolio){
        servicioInversion.activarPortafolios(idUsuario, idPortafolio);
    }

    //Devuelve los días de activación de un portafolio
    @GetMapping("/dias-activacion/{idPortafolio}")
    public Integer obtenerTiempoActivacion(@PathVariable("idPortafolio") Integer idPortafolio){
        return servicioInversion.obtenerTiempoActivacion(idPortafolio);
    }

}
