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

@Qualifier("dao")
@Repository
public class GlucosaDaoImpl implements GlucosaInterfaz {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Response2<Boolean> InsertarGlucosa(GlucosaModel glucosa) {
        Response2<Boolean> out;
       
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("SP_InsertarGlucosa");

            SqlParameterSource input = new MapSqlParameterSource() 
                .addValue("p_nivel_glucosa", glucosa.getNivel_glucosa());

            jdbcCall.execute(input);
            out = new Response2<>(HttpStatus.CREATED, "Glucosa insertada correctamente", true);
       } catch (Exception e) {
           out = new Response2<>(e);
       }
         return out;

    }

}