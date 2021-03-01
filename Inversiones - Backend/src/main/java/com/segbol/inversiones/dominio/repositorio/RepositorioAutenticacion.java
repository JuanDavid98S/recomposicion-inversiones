package com.segbol.inversiones.dominio.repositorio;

import com.segbol.inversiones.persistencia.entidades.Usuario;
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
public class RepositorioAutenticacion implements IRepositorioAutenticacion{

    private SimpleJdbcCall call;
    private JdbcTemplate template;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.template = jdbc;
        this.call = new SimpleJdbcCall(jdbc);
    }

    //Método que devuelve un objeto de tipo usuario por su identificador
    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_AUTENTICACION").withProcedureName("verificarUsuario")
                .declareParameters(
                        new SqlParameter("u_idUsuario", Types.NUMERIC),
                        new SqlOutParameter("usuario", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Usuario.class))
                );
        call.compile();
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("u_idUsuario", idUsuario);
        ArrayList<Usuario> usuario = (ArrayList<Usuario>) call.execute(map).get("usuario");

        return usuario.get(0);
    }

    //Método que devuelve una lista de objetos de tipo usuario con usuario.tipo = 'cliente'
    @Override
    public ArrayList<Usuario> listarUsuarios() {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_AUTENTICACION").withProcedureName("listarUsuarios")
                .declareParameters(
                        new SqlOutParameter("usuarios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Usuario.class))
                );
        call.compile();

        return (ArrayList<Usuario>) call.execute().get("usuarios");
    }

    //Método que devuelve una lista de objetos de tipo usuario con usuario.tipo = 'administrador'
    @Override
    public ArrayList<Usuario> listarAdmins() {
        setJdbcTemplate(template);
        call.withCatalogName("PCK_AUTENTICACION").withProcedureName("listarAdmins")
                .declareParameters(
                        new SqlOutParameter("usuarios", Types.REF_CURSOR, new BeanPropertyRowMapper<>(Usuario.class))
                );
        call.compile();

        return (ArrayList<Usuario>) call.execute().get("usuarios");
    }
}
