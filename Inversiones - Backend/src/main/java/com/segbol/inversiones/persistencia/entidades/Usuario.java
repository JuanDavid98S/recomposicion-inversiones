package com.segbol.inversiones.persistencia.entidades;

import java.util.Calendar;

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String documento;
    private Calendar fechaIngreso;
    private String tipo;
    private Integer idCiudad;
    private Double totalInvertido;


    public Usuario() {
    }

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, String correo, String contrasena, String documento, Calendar fechaIngreso, Integer idCiudad, Double totalInvertido, String tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.idCiudad = idCiudad;
        this.totalInvertido = totalInvertido;
        this.tipo = tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Double getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(Double totalInvertido) {
        this.totalInvertido = totalInvertido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
