package com.RDT_PastillasSercio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RDT_PastillasSercio.Interfaz.UsuarioInterfaz;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;
import com.RDT_PastillasSercio.util.consts.ApiConst;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(ApiConst.USUARIO)
@CrossOrigin("*")
public class UsuarioControlador {

    @Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
    @Autowired
    UsuarioInterfaz usuarioServicio;

    @PostMapping(produces = ApiConst.PRODUCES)
public ResponseEntity<?> InsertarUsuario(@RequestBody UsuarioModel usuario) {
        Response2<Boolean> out;
        out = usuarioServicio.InsertarUsuario(usuario);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

}
 