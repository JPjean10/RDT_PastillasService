package com.RDT_PastillasSercio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RDT_PastillasSercio.Interfaz.LogInterfaz;
import com.RDT_PastillasSercio.Interfaz.PresionInterfaz;
import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.PresionModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.ApiConst;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(ApiConst.PRESION)
@CrossOrigin("*")
public class PresionControlador {

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    private LogInterfaz serviceLog;

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    PresionInterfaz presionServicio;

    @PostMapping(produces = ApiConst.PRODUCES)
    public ResponseEntity<?> InsertarPresion(HttpServletRequest http, @RequestBody PresionModel presion) {
        LogModel logModel = serviceLog.setRequestData(http, presion, presion.getId_usuario());

        Response2<Boolean> out;
        out = presionServicio.InsertarPresion(presion);

        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

}
