package com.RDT_PastillasSercio.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RDT_PastillasSercio.Interfaz.LogInterfaz;
import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;
import com.RDT_PastillasSercio.util.DateUtil;
import com.RDT_PastillasSercio.util.consts.CommonConsts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
@Service
public class LogServiceImpl implements LogInterfaz {

    @Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
    @Autowired
    private LogInterfaz logDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public LogModel setRequestData(HttpServletRequest httpRequest, Object request, Long id_usuario) {

        LogModel logModel = new LogModel();

        logModel.setIp(httpRequest.getRemoteAddr());
        logModel.setMethod(httpRequest.getMethod());
        logModel.setEnd_point(httpRequest.getRequestURI());
        logModel.setBegin_date_time(DateUtil.getCurrentDateTime());
        logModel.setId_usuario(id_usuario);
        logModel.setResponse_body("");

        try {
            logModel.setRequest_body(request == null ? null : objectMapper.writeValueAsString(request));

        } catch (JsonProcessingException ex) {
            logModel.setRequest_body(ex.getMessage());
        }

        return logModel;
    }

    @Override
    public <T> void setResponseData(LogModel logModel, Response2<T> response) {

        logModel.setRequest_code(response.getErrorId() == null ? DateUtil.generateId() : response.getErrorId());
        logModel.setError_(response.getErrorMssg());
        logModel.setHttp_status_code(response.getStatusCode().value());
        logModel.setEnd_date_time(DateUtil.getCurrentDateTime());

        try {
                logModel.setResponse_body(objectMapper.writeValueAsString(response));
        } catch (JsonProcessingException ex) {
            logModel.setResponse_body(ex.getMessage());
        }

        logModel.setError_(response.getErrorMssg());
    }

    @Override
    public void insert(LogModel request) {
        logDao.insert(request);
    }

    @Override
    public <T> CompletableFuture<Void> save(LogModel logModel) {
        return CompletableFuture.runAsync(() -> {
            insert(logModel);
        });
    }

    @Override
    public <T> T clone(T request, Class<T> clazz) {
        try {
            // Convertir el objeto a JSON
            String json = objectMapper.writeValueAsString(request);

            // Convertir el JSON de vuelta al objeto
            T responseClon = objectMapper.readValue(json, clazz);

            return responseClon;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public <T> void setResponseDataAndSave(LogModel logModel, Response2<T> response) {
        setResponseData(logModel, response);

        save(logModel);
    }

}
 