package com.RDT_PastillasSercio.Interfaz;

import com.RDT_PastillasSercio.model.Response2;
import com.RDT_PastillasSercio.model.UsuarioModel;

public interface UsuarioInterfaz {

  Response2<Boolean> InsertarUsuario(UsuarioModel usuario);

}
