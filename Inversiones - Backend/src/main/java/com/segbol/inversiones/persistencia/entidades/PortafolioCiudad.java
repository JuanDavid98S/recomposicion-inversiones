package com.segbol.inversiones.persistencia.entidades;

public class PortafolioCiudad {

    private Integer idPortafolioCiudad;
    private Integer idPortafolio;
    private Integer idCiudad;

    public PortafolioCiudad() {
    }

    public PortafolioCiudad(Integer idPortafolioCiudad, Integer idPortafolio, Integer idCiudad) {
        this.idPortafolioCiudad = idPortafolioCiudad;
        this.idPortafolio = idPortafolio;
        this.idCiudad = idCiudad;
    }

    public Integer getIdPortafolioCiudad() {
        return idPortafolioCiudad;
    }

    public void setIdPortafolioCiudad(Integer idPortafolioCiudad) {
        this.idPortafolioCiudad = idPortafolioCiudad;
    }

    public Integer getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(Integer idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
}
