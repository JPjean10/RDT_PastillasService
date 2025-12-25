package com.RDT_PastillasSercio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RDT_PastillasSercio.Interfaz.PresionInterfaz;
import com.RDT_PastillasSercio.model.PresionModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

@Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
@Service
public class PresionServicioImpl implements PresionInterfaz {

    @Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
    @Autowired
    PresionInterfaz presionDao;

    @Override
    public Response2<Boolean> InsertarPresion(PresionModel presion) {
        return presionDao.InsertarPresion(presion);
    }

    
}
