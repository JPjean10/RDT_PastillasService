package com.RDT_PastillasSercio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.RDT_PastillasSercio.Interfaz.GlucosaInterfaz;
import com.RDT_PastillasSercio.model.GlucosaModel;
import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.util.consts.CommonConsts;

@Qualifier(CommonConsts.RDT_PASTILLAS_SERVICE)
@Service
public class GlucosaServicioImpl implements GlucosaInterfaz {

     @Qualifier(CommonConsts.RDT_PASTILLAS_DAO)
     @Autowired
     GlucosaInterfaz glucosaDao;

    @Override
    public Response2<Boolean> InsertarGlucosa(GlucosaModel glucosa) {
       return glucosaDao.InsertarGlucosa(glucosa);
    }

    @Override
    public Response2<Boolean> EditarGlucosa(GlucosaModel glucosa) {
      return glucosaDao.EditarGlucosa(glucosa);
    }

    @Override
    public Response2<Boolean> SincronizarGlucosa(GlucosaModel glucosa) {
        return glucosaDao.SincronizarGlucosa(glucosa);
    }

}
