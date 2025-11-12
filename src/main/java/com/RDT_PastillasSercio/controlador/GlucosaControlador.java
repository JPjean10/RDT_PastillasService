package com.RDT_PastillasSercio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RDT_PastillasSercio.Interfaz.GlucosaInterfaz;
import com.RDT_PastillasSercio.model.GlucosaModel;
import com.RDT_PastillasSercio.model.Response2;
import org.springframework.web.bind.annotation.RequestBody;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Glucosa")
@CrossOrigin("*")
public class GlucosaControlador {


    @Qualifier("service")
    @Autowired
    GlucosaInterfaz glucosaServicio;

    @PostMapping(path = "insert", consumes = "application/json")
    public ResponseEntity<?> InsertarGlucosa(@RequestBody GlucosaModel glucosa){
        Response2<Boolean> out;
        out = glucosaServicio.InsertarGlucosa(glucosa);
        return ResponseEntity.status(out.getStatusCode()).body(out);
    }

}
