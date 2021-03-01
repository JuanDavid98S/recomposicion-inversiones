package com.segbol.inversiones.persistencia.entidades;

public class UsuarioPortafolio {
    private Integer idUsuario;
    private Integer idPortafolio;
    private Double montoInvertido;
    private Character inactivo;

    public UsuarioPortafolio() {
    }

    public UsuarioPortafolio(Integer idUsuario, Integer idPortafolio, Double montoInvertido, Character inactivo) {
        this.idUsuario = idUsuario;
        this.idPortafolio = idPortafolio;
        this.montoInvertido = montoInvertido;
        this.inactivo = inactivo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(Integer idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public Double getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(Double montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public Character getInactivo() {
        return inactivo;
    }

    public void setInactivo(Character inactivo) {
        this.inactivo = inactivo;
    }
}
