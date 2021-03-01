package com.segbol.inversiones.dominio.repositorio;

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

import java.sql.Types;
import java.util.ArrayList;

@Service
public class RepositorioInversion implements IRepositorioInversion{

    private SimpleJdbcCall call;
    private JdbcTemplate template;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.template = jdbc;
        this.call = new SimpleJdbcCall(jdbc);
    }

    //Devuelve una interfaz de apoyo que contiene información sobre el usuario, el portafolio y la inversión realizada
    @Override
    public PortafoliosUsuario obtenerInversion(Integer idUsuarioPortafolio) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_INVERSIONES").withProcedureName("obtenerPortafolioActivo")
                .declareParameters(
                        new SqlParameter("up_idUsuarioPortafolio", Types.NUMERIC),
                        new SqlOutParameter("usuarioPortafolio", Types.REF_CURSOR, new BeanPropertyRowMapper<>(PortafoliosUsuario.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("up_idUsuarioPortafolio", idUsuarioPortafolio);
        ArrayList<PortafoliosUsuario> inversion = (ArrayList<PortafoliosUsuario>) call.execute(map).get("usuarioPortafolio");

        return inversion.get(0);
    }

    //Almacena la inversión realizada en la base de datos
    @Override
    public void recomponerInversion(Integer idUsuario, Integer idPortafolio, Double montoInvertido) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_INVERSIONES").withProcedureName("recomponerInversion")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.NUMERIC),
                        new SqlParameter("p_idPortafolio", Types.NUMERIC),
                        new SqlParameter("montoInvertido", Types.DOUBLE)
                );
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario)
                .addValue("p_idPortafolio", idPortafolio)
                .addValue("montoInvertido", montoInvertido);

        call.executeFunction(void.class, map);
    }

    //Activa los portafolios que estén inactivos según el usuario
    @Override
    public void activarPortafolios(Integer idUsuario, Integer idPortafolio) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_INVERSIONES").withProcedureName("activarPortafolios")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.BIGINT),
                        new SqlParameter("p_idPortafolio", Types.BIGINT)
                );
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario)
                .addValue("p_idPortafolio", idPortafolio);

        call.executeFunction(void.class, map);
    }

    //Devuelve el tiempo en días hábiles en que se debe activar el portafolio
    @Override
    public Integer obtenerTiempoActivacion(Integer idPortafolio) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_INVERSIONES").withProcedureName("obtenerTiempoActivacion")
                .declareParameters(new SqlParameter("p_idPortafolio", Types.BIGINT));
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("p_idPortafolio", idPortafolio);

        return call.executeFunction(Integer.class, map);
    }
}
