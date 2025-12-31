package com.RDT_PastillasSercio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.RDT_PastillasSercio.Interfaz.PresionInterfaz;
import com.RDT_PastillasSercio.model.PresionModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.CommonConsts;
import com.RDT_PastillasSercio.util.consts.DbConst;

@Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
@Repository
public class PresionDaoImpl implements PresionInterfaz {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Response2<Boolean> InsertarPresion(PresionModel presion) {
        Response2<Boolean> out;

                try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_INSERTAR_PRESION);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", presion.getId_usuario())
                    .addValue("p_id_presion", presion.getId_presion())
                    .addValue("p_sys", presion.getSys())
                    .addValue("p_dia", presion.getDia())
                    .addValue("p_pul", presion.getPul())
                    .addValue("p_fecha_hora_creacion", presion.getFecha_hora_creacion())
                    .addValue("p_estado", presion.isEstado());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Presion insertada correctamente", true);
        } catch (Exception e) {
            out = new Response2<>(e);
        }
        return out;

    }

    @Override
    public Response2<Boolean> EditarPresion(PresionModel presion) {
        Response2<Boolean> out;
            try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_EDITAR_PRESION);

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", presion.getId_usuario())
                    .addValue("p_id_presion", presion.getId_presion())
                    .addValue("p_sys", presion.getSys())
                    .addValue("p_dia", presion.getDia())
                    .addValue("p_pul", presion.getPul())
                    .addValue("p_fecha_hora_creacion", presion.getFecha_hora_creacion())
                    .addValue("p_estado", presion.isEstado());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Presion actulizada correctamente", true);
        } catch (Exception e) {
            out = new Response2<>(e);
        }
        return out;
    }

    @Override
    public Response2<Boolean> SincronizarPresion(PresionModel presion) {
        Response2<Boolean> out;

        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName(DbConst.SP_SINCRONIZAR_PRESION);


            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", presion.getId_usuario())
                    .addValue("p_id_presion", presion.getId_presion())
                    .addValue("p_sys", presion.getSys())
                    .addValue("p_dia", presion.getDia())
                    .addValue("p_pul", presion.getPul())
                    .addValue("p_fecha_hora_creacion", presion.getFecha_hora_creacion())
                    .addValue("p_estado", presion.isEstado());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.OK, "Sincronizacion de presion realizada correctamente", true);
        } catch (Exception e) {
            out = new Response2<>(e);
        }
        return out;
    }

}
