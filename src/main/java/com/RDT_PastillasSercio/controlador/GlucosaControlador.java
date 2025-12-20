package com.RDT_PastillasSercio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RDT_PastillasSercio.Interfaz.GlucosaInterfaz;
import com.RDT_PastillasSercio.Interfaz.LogInterfaz;
import com.RDT_PastillasSercio.model.GlucosaModel;
import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.ApiConst;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(ApiConst.GLUCOSA)
@CrossOrigin("*")
public class GlucosaControlador {

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    GlucosaInterfaz glucosaServicio;

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    private LogInterfaz serviceLog;

    @PostMapping(produces = ApiConst.PRODUCES)
    public ResponseEntity<?> InsertarGlucosa(HttpServletRequest http,@RequestBody GlucosaModel glucosa) {
        LogModel logModel = serviceLog.setRequestData(http, glucosa, glucosa.getId_usuario());
        
        Response2<Boolean> out;
        out = glucosaServicio.InsertarGlucosa(glucosa);

        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

    @PutMapping(produces = ApiConst.PRODUCES)
    public ResponseEntity<?> EditarGlucosa(HttpServletRequest http,@RequestBody GlucosaModel glucosa){
    LogModel logModel = serviceLog.setRequestData(http, glucosa, glucosa.getId_usuario());

        Response2<Boolean> out;
        out = glucosaServicio.EditarGlucosa(glucosa);

        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

    @PostMapping(value = ApiConst.SINCRONIZAR, produces = ApiConst.PRODUCES)
    public ResponseEntity<?> SincronizarGlucosaIsert(HttpServletRequest http,@RequestBody GlucosaModel glucosa) {
        LogModel logModel = serviceLog.setRequestData(http, glucosa, glucosa.getId_usuario());

        Response2<Boolean> out;
        out = glucosaServicio.SincronizarGlucosaIsert(glucosa);

        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

    @PutMapping(value = ApiConst.SINCRONIZAR, produces = ApiConst.PRODUCES)
    public ResponseEntity<?> SincronizarGlucosaActualizar(HttpServletRequest http,@RequestBody GlucosaModel glucosa) {
        LogModel logModel = serviceLog.setRequestData(http, glucosa, glucosa.getId_usuario());

        Response2<Boolean> out;
        out = glucosaServicio.SincronizarGlucosaActualizar(glucosa);
        
        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }
}
