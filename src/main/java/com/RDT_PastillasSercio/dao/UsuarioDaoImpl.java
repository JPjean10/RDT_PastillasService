package com.RDT_PastillasSercio.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.RDT_PastillasSercio.util.DbUtil;
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
                    .addValue("p_contrasena", usuario.getContrasena())
                    .addValue("p_nombre", usuario.getNombre());

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

    @Override
    public Response2<List<UsuarioModel>> Login(UsuarioModel usuario) {
        Response2<List<UsuarioModel>> out = new Response2<>();

        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_INISIAR_SESION);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_usuario", usuario.getUsuario())
                    .addValue("p_contrasena", usuario.getContrasena());

            Map<String, Object> dbData = jdbcCall.execute(input);
            List<Map<String, Object>> resultset = (List<Map<String, Object>>) dbData.get(DbConst.RESUL_SET_1);

            if (resultset != null && !resultset.isEmpty()) {

                out.setData(new ArrayList<>());
                UsuarioModel dataUser;

                for (Map<String, Object> row : resultset) {

                    dataUser = new UsuarioModel();

                    dataUser.setId_usuario(DbUtil.getLong(row, "id_usuario"));
                    dataUser.setUsuario(DbUtil.getString(row, "usuario"));
                    dataUser.setContrasena(DbUtil.getString(row, "contrasena"));
                    dataUser.setNombre(DbUtil.getString(row, "nombre"));
                    dataUser.setFechaHoraCreacion(DbUtil.getfecha_hora(row, "fecha_hora_creacion"));

                    out.getData().add(dataUser);
                }

            }

        } catch (Exception ex) {
            out = new Response2<>(ex);
        }

        return out;
    }

}
