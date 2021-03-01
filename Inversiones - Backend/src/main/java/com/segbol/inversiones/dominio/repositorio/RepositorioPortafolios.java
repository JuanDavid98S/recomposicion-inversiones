package com.segbol.inversiones.dominio.repositorio;

import com.segbol.inversiones.persistencia.entidades.Portafolio;
import com.segbol.inversiones.persistencia.entidades.PortafolioCiudad;
import com.segbol.inversiones.persistencia.entidades.PortafoliosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;

@Service
public class RepositorioPortafolios implements IRepositorioPortafolio{

    private SimpleJdbcCall call;
    private JdbcTemplate template;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.template = jdbc;
        this.call = new SimpleJdbcCall(jdbc);
    }

    //Muestra los portafolios que tiene activos el usuario
    @Override
    public ArrayList<PortafoliosUsuario> mostrarPortafoliosUsuario(Integer idUsuario) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("mostrarPortafoliosUsuario")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.NUMERIC),
                        new SqlOutParameter("portafolios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(PortafoliosUsuario.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario);
        ArrayList<PortafoliosUsuario> portafolios = (ArrayList<PortafoliosUsuario>) call.execute(map).get("portafolios");

        return portafolios;
    }

    //Muestra los portafolios disponibles a los usuarios que los requieran (sin incluir los premium)
    @Override
    public ArrayList<Portafolio> mostrarPortafoliosDisponibles(Integer idUsuario) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("mostrarPortafoliosDisponibles")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.NUMERIC),
                        new SqlOutParameter("portafolios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Portafolio.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario);
        ArrayList <Portafolio> portafolios = (ArrayList<Portafolio>) call.execute(map).get("portafolios");

        return portafolios;
    }

    //Muestra los portafolios Premium del sistema al usuario que los solicite
    @Override
    public ArrayList<Portafolio> mostrarPortafoliosEspeciales(Integer idUsuario, Double totalInvertido, Integer idCiudad, Integer ingresoEmpresa) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("mostrarPortafoliosEspeciales")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.NUMERIC),
                        new SqlParameter("u_totalInvertido", Types.NUMERIC),
                        new SqlParameter("u_idCiudad", Types.NUMERIC),
                        new SqlParameter("u_ingresoEmpresa", Types.NUMERIC),
                        new SqlOutParameter("portafolios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Portafolio.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario)
                .addValue("u_totalInvertido", totalInvertido)
                .addValue("u_idCiudad", idCiudad)
                .addValue("u_ingresoEmpresa", ingresoEmpresa);
        ArrayList<Portafolio> portafolios = (ArrayList<Portafolio>) call.execute(map).get("portafolios");

        return portafolios;
    }

    //Muestra todos los portafolios para devolverlos al usuario de tipo administrador
    @Override
    public ArrayList<Portafolio> mostrarTodosPortafolios() {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("mostrarTodosPortafolios").
                declareParameters(
                        new SqlOutParameter("portafolios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Portafolio.class))
                );
        call.compile();
        ArrayList<Portafolio> portafolios = (ArrayList<Portafolio>) call.execute().get("portafolios");

        return portafolios;
    }

    //Devuelve un portafolio específico por su id
    @Override
    public Portafolio verDetallesPortafolio(Integer idPortafolio) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("mostrarPortafolio")
                .declareParameters(
                        new SqlParameter("p_idPortafolio", Types.NUMERIC),
                        new SqlOutParameter("portafolio", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Portafolio.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("p_idPortafolio", idPortafolio);
        ArrayList<Portafolio> portafolio = (ArrayList<Portafolio>) call.execute(map).get("portafolio");

        return portafolio.get(0);
    }

    //Actualiza las condiciones para los portafolios que requiera el administrador
    @Override
    public void cambiarCondiciones(Integer idPortafolio, Integer ingresoEmpresa, Double inversionTotalMinima) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("cambiarCondiciones")
                .declareParameters(
                        new SqlParameter("p_idPortafolio", Types.NUMERIC),
                        new SqlParameter("ingresoEmpresa", Types.NUMERIC),
                        new SqlParameter("inversionTotalMinima", Types.DOUBLE),
                        new SqlOutParameter("idPortafolio", Types.NUMERIC)
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("p_idPortafolio", idPortafolio)
                .addValue("ingresoEmpresa", ingresoEmpresa)
                .addValue("inversionTotalMinima", inversionTotalMinima);

        call.execute(map).get("idPortafolio");
    }

    //Devuelve las ciudades asociadas al portafolio
    @Override
    public ArrayList<PortafolioCiudad> obtenerCiudades(Integer idPortafolio) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("obtenerCiudadesPortafolio")
                .declareParameters(
                        new SqlParameter("p_idPortafolio", Types.NUMERIC),
                        new SqlOutParameter("ciudades", Types.REF_CURSOR, new BeanPropertyRowMapper<>(PortafolioCiudad.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("p_idPortafolio", idPortafolio);

        ArrayList<PortafolioCiudad> portafolioCiudad = (ArrayList<PortafolioCiudad>) call.execute(map).get("ciudades");

        return portafolioCiudad;
    }

    //Actualiza la relación de portafolios y ciudades según lo requiera el administrador
    @Override
    public BigDecimal actualizarCiudad(Integer idPortafolio, Integer idCiudad) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_OPERACIONES_PORTAFOLIOS").withProcedureName("actualizarCiudad")
                .declareParameters(
                        new SqlParameter("p_idPortafolio", Types.NUMERIC),
                        new SqlParameter("c_idCiudad", Types.NUMERIC),
                        new SqlOutParameter("portafolioCiudad", Types.NUMERIC)
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("p_idPortafolio", idPortafolio)
                .addValue("c_idCiudad", idCiudad);

        return (BigDecimal) call.execute(map).get("portafolioCiudad");
    }

}
