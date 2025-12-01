package com.RDT_PastillasSercio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.RDT_PastillasSercio.Interfaz.UsuarioInterfaz;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;
import com.RDT_PastillasSercio.util.consts.CommonConsts;
import com.RDT_PastillasSercio.util.consts.DbConst;

@Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
@Repository
public class UsuarioDaoImpl implements UsuarioInterfaz {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Response2<Boolean> InsertarUsuario(UsuarioModel usuario) {
        Response2<Boolean> out;

        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_INSERTAR_USUARIO);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_usuario", usuario.getUsuario())
                    .addValue("p_contrasena", usuario.getContrasena());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Usuario insertado correctamente", true);
        } catch (UncategorizedSQLException e) {
            int errorId = Integer.parseInt(e.getSQLException().getSQLState());
            out = new Response2<>(e, errorId);
        } catch (Exception e) {
            out = new Response2<>(e);
        }

        return out;
    }


}
