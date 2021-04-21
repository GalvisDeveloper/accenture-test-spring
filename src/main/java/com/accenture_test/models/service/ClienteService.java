package com.accenture_test.models.service;

import com.accenture_test.models.entity.Cliente;
import com.accenture_test.models.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    private FacturaService facturaService;

    public String añadirProducto(String id){
        return facturaService.addProducto(id);
    }

    public Factura obtenerFactura(){
        facturaService.subTotal();
        facturaService.calcularTotal();
        return facturaService.getFactura();
    }

}
