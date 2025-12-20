package com.RDT_PastillasSercio.Interfaz;

import java.util.concurrent.CompletableFuture;

import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.Response2;

import jakarta.servlet.http.HttpServletRequest;

public interface LogInterfaz {

    LogModel setRequestData(HttpServletRequest httpRequest, Object request, Long id_usuario);

    <T> void setResponseData(LogModel logModel, Response2<T> response);

    void insert(LogModel request);

    <T> CompletableFuture<Void> save(LogModel logModel);

    <T> T clone(T request, Class<T> clazz);

    <T> void setResponseDataAndSave(LogModel logModel, Response2<T> response);

}
 