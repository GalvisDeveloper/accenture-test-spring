package com.accenture_test.controllers;

import com.accenture_test.models.entity.Factura;
import com.accenture_test.models.entity.Producto;
import com.accenture_test.models.service.ClienteService;
import com.accenture_test.models.service.FacturaService;
import com.accenture_test.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private ClienteService cliente;
    @Autowired
    private ProductoService producto;
    @Autowired
    private FacturaService factura;

    @GetMapping("/compra/{id}")
    public String index (@PathVariable String id) {
        return factura.addProducto(id);
    }

    @GetMapping("/productos")
    public List<Producto> productos (){
        return producto.getAllProducts();
    }

    @GetMapping("/factura")
    public Factura productosFactura () {
       return cliente.obtenerFactura();
    }
}
