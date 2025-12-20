package com.RDT_PastillasSercio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RDT_PastillasSercio.Interfaz.LogInterfaz;
import com.RDT_PastillasSercio.Interfaz.UsuarioInterfaz;
import com.RDT_PastillasSercio.model.LogModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;
import com.RDT_PastillasSercio.util.consts.ApiConst;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(ApiConst.USUARIO)
@CrossOrigin("*")
public class UsuarioControlador {

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    UsuarioInterfaz usuarioServicio;

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    private LogInterfaz serviceLog;

    @PostMapping(produces = ApiConst.PRODUCES)
public ResponseEntity<?> InsertarUsuario(HttpServletRequest http,@RequestBody UsuarioModel usuario) {
    LogModel logModel = serviceLog.setRequestData(http, usuario, null);
    
        Response2<Boolean> out;
        out = usuarioServicio.InsertarUsuario(usuario);

        serviceLog.setResponseDataAndSave(logModel, out);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

    @PostMapping(path = ApiConst.LOGIN, produces = ApiConst.PRODUCES)
    public ResponseEntity<?> Login(HttpServletRequest http,@RequestBody UsuarioModel usuario) { 
        LogModel logModel = serviceLog.setRequestData(http, usuario, null);
        
            Response2<List<UsuarioModel>> out;
            out = usuarioServicio.Login(usuario);
    
            serviceLog.setResponseDataAndSave(logModel, out);
            return ResponseEntity.status(out.getStatusCode()).body(out);
        }

}
