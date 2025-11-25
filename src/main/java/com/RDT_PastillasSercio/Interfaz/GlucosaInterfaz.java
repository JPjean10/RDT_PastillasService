package com.RDT_PastillasSercio.Interfaz;

import com.RDT_PastillasSercio.model.GlucosaModel;
import com.RDT_PastillasSercio.model.Response2;

public interface GlucosaInterfaz {

    Response2<Boolean> InsertarGlucosa(GlucosaModel glucosa);
 
    Response2<Boolean> EditarGlucosa (GlucosaModel glucosa);

    Response2<Boolean> SincronizarGlucosa (GlucosaModel glucosa);
}
