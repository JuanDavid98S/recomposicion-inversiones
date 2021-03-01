package com.segbol.inversiones.persistencia.entidades;

public class PortafoliosUsuario {
    //Clase de apoyo para la inversión
    private Integer idUsuarioPortafolio;
    private Integer idPortafolio;
    private String nombre;
    private Double minimoInversion;
    private Double minimaPermanencia;
    private Integer diasActivacion;
    private Integer idUsuario;
    private Double montoInvertido;
    private String estado;
    private String estadoGestion;

    public PortafoliosUsuario() {
    }

    public PortafoliosUsuario(Integer idUsuarioPortafolio, Integer idPortafolio, String nombre, Double minimoInversion, Double minimaPermanencia, Integer diasActivacion, Integer idUsuario, Double montoInvertido, String estado, String estadoGestion) {
        this.idUsuarioPortafolio = idUsuarioPortafolio;
        this.idPortafolio = idPortafolio;
        this.nombre = nombre;
        this.minimoInversion = minimoInversion;
        this.minimaPermanencia = minimaPermanencia;
        this.diasActivacion = diasActivacion;
        this.idUsuario = idUsuario;
        this.montoInvertido = montoInvertido;
        this.estado = estado;
        this.estadoGestion = estadoGestion;
    }

    public Integer getIdUsuarioPortafolio() {
        return idUsuarioPortafolio;
    }

    public void setIdUsuarioPortafolio(Integer idUsuarioPortafolio) {
        this.idUsuarioPortafolio = idUsuarioPortafolio;
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

    public Double getMinimaPermanencia() {
        return minimaPermanencia;
    }

    public void setMinimaPermanencia(Double minimaPermanencia) {
        this.minimaPermanencia = minimaPermanencia;
    }

    public Integer getDiasActivacion() {
        return diasActivacion;
    }

    public void setDiasActivacion(Integer diasActivacion) {
        this.diasActivacion = diasActivacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(Double montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoGestion() {
        return estadoGestion;
    }

    public void setEstadoGestion(String estadoGestion) {
        this.estadoGestion = estadoGestion;
    }
}
