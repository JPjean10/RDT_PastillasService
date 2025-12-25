package com.RDT_PastillasSercio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.RDT_PastillasSercio.Interfaz.GlucosaInterfaz;
import com.RDT_PastillasSercio.model.GlucosaModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.CommonConsts;
import com.RDT_PastillasSercio.util.consts.DbConst;

@Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
@Repository
public class GlucosaDaoImpl implements GlucosaInterfaz {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Response2<Boolean> InsertarGlucosa(GlucosaModel glucosa) {
        Response2<Boolean> out;

        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_INSERTAR_GLUCOSA);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", glucosa.getId_usuario())
                    .addValue("p_id_glucosa", glucosa.getId_glucosa())
                    .addValue("p_nivel_glucosa", glucosa.getNivel_glucosa())
                    .addValue("p_fecha_hora_creacion", glucosa.getFecha_hora_creacion())
                    .addValue("p_estado", glucosa.getEstado());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Glucosa insertada correctamente", true);
        } catch (Exception e) {
            out = new Response2<>(e);
        }
        return out;

    }

    @Override
    public Response2<Boolean> EditarGlucosa(GlucosaModel glucosa) {
        Response2<Boolean> out;

        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_SINCRONIZAR_GLUCOSA_ACTUALIZAR);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", glucosa.getId_usuario())
                    .addValue("p_id_glucosa", glucosa.getId_glucosa())
                    .addValue("p_nivel_glucosa", glucosa.getNivel_glucosa())
                    .addValue("p_fecha_hora_creacion", glucosa.getFecha_hora_creacion())
                    .addValue("p_estado", glucosa.getEstado());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Glucosa insertada correctamente", true);
        } catch (Exception e) {
            out = new Response2<>(e);
        }
        return out;
    }
}