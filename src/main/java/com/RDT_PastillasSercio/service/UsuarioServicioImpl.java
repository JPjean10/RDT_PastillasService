package com.RDT_PastillasSercio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RDT_PastillasSercio.Interfaz.UsuarioInterfaz;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

@Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
@Service
public class UsuarioServicioImpl implements UsuarioInterfaz {

    @Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
    @Autowired
    UsuarioInterfaz usuarioDao;

    @Override
    public Response2<Boolean> InsertarUsuario(UsuarioModel usuario) {
        return usuarioDao.InsertarUsuario(usuario);
    }

}
