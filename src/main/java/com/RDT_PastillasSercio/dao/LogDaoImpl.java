package com.RDT_PastillasSercio.dao;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.RDT_PastillasSercio.Interfaz.LogInterfaz;
import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.CommonConsts;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
@Repository
public class LogDaoImpl implements LogInterfaz {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void insert(LogModel request) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("SP_LogService");

            SqlParameterSource input = new MapSqlParameterSource()
                    .addValue("p_id_usuario", request.getId_usuario())
                    .addValue("p_request_code", request.getRequest_code())
                    .addValue("p_http_status_code", request.getHttp_status_code())
                    .addValue("p_ip", request.getIp())
                    .addValue("p_method", request.getMethod())
                    .addValue("p_end_point", request.getEnd_point())
                    .addValue("p_request_header", request.getRequest_header())
                    .addValue("p_request_body", request.getRequest_body())
                    .addValue("p_response_body", request.getResponse_body())
                    .addValue("p_error_", request.getError_())
                    .addValue("p_begin_date_time", request.getBegin_date_time())
                    .addValue("p_end_date_time", request.getEnd_date_time());

            jdbcCall.execute(input);
        } catch (Exception e) {
            e.printStackTrace(); // ver en consola
            throw e;
        }
    }

    @Override
    public LogModel setRequestData(HttpServletRequest httpRequest, Object request, Long profileId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRequestData'");
    }


    @Override
    public <T> void setResponseData(LogModel logModel, Response2<T> response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setResponseData'");
    }

    @Override
    public <T> CompletableFuture<Void> save(LogModel logModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <T> T clone(T request, Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

    @Override
    public <T> void setResponseDataAndSave(LogModel logModel, Response2<T> response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setResponseDataAndSave'");
    }

}
 