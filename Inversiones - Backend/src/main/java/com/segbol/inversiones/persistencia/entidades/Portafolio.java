package com.segbol.inversiones.persistencia.entidades;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Portafolio {

    private Integer idPortafolio;
    private String nombre;
    private Double minimoInversion;
    private Integer minimaPermanencia;
    private Integer diasActivacion;
    private Double penalizacion;
    private Integer ingresoEmpresa;
    private Double inversionTotalMinima;

    private PortafolioCiudad portafolioCiudad;


    public Portafolio(){

    };

    public Portafolio(Integer idPortafolio, String nombre, Double minimoInversion, Integer minimaPermanencia, Integer diasActivacion, Double penalizacion, Integer ingresoEmpresa, Double inversionTotalMinima, PortafolioCiudad portafolioCiudad) {
        this.idPortafolio = idPortafolio;
        this.nombre = nombre;
        this.minimoInversion = minimoInversion;
        this.minimaPermanencia = minimaPermanencia;
        this.diasActivacion = diasActivacion;
        this.penalizacion = penalizacion;
        this.ingresoEmpresa = ingresoEmpresa;
        this.inversionTotalMinima = inversionTotalMinima;
        this.portafolioCiudad = portafolioCiudad;
    }

    public Integer getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(Integer idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMinimoInversion() {
        return minimoInversion;
    }

    public void setMinimoInversion(Double minimoInversion) {
        this.minimoInversion = minimoInversion;
    }

    public Integer getMinimaPermanencia() {
        return minimaPermanencia;
    }

    public void setMinimaPermanencia(Integer minimaPermanencia) {
        this.minimaPermanencia = minimaPermanencia;
    }

    public Integer getDiasActivacion() {
        return diasActivacion;
    }

    public void setDiasActivacion(Integer diasActivacion) {
        this.diasActivacion = diasActivacion;
    }

    public Double getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(Double penalizacion) {
        this.penalizacion = penalizacion;
    }

    public Integer getIngresoEmpresa() {
        return ingresoEmpresa;
    }

    public void setIngresoEmpresa(Integer ingresoEmpresa) {
        this.ingresoEmpresa = ingresoEmpresa;
    }

    public Double getInversionTotalMinima() {
        return inversionTotalMinima;
    }

    public void setInversionTotalMinima(Double inversionTotalMinima) {
        this.inversionTotalMinima = inversionTotalMinima;
    }

    public PortafolioCiudad getPortafolioCiudad() {
        return portafolioCiudad;
    }

    public void setPortafolioCiudad(PortafolioCiudad portafolioCiudad) {
        this.portafolioCiudad = portafolioCiudad;
    }

    @Override
    public String toString() {
        return "Portafolio{" +
                "idPortafolio=" + idPortafolio +
                ", nombre='" + nombre + '\'' +
                ", minimoInversion=" + minimoInversion +
                ", minimaPermanencia=" + minimaPermanencia +
                ", diasActivacion=" + diasActivacion +
                ", penalizacion=" + penalizacion +
                ", ingresoEmpresa=" + ingresoEmpresa +
                ", inversionTotalMinima=" + inversionTotalMinima +
                '}';
    }
}
