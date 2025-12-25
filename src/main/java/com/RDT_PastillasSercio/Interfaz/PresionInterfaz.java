package com.RDT_PastillasSercio.Interfaz;

import com.RDT_PastillasSercio.model.PresionModel;
import com.RDT_PastillasSercio.model.Response2;

public interface PresionInterfaz {

    Response2<Boolean> InsertarPresion(PresionModel presion);

}
