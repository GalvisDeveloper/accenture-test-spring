package com.accenture_test.models.service;

import com.accenture_test.models.entity.Cliente;
import com.accenture_test.models.entity.Factura;
import com.accenture_test.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private Factura factura;

    @Autowired
    private ProductoService prodService;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaService(){
        factura = Factura.getInstance();
    }

    public void calcularTotal(){
        factura.calcularTotal();
    }

    public void subTotal (){
        factura.subTotal();
    }

    public String addProducto(String prod){
        String cad = "";
        Producto p = prodService.getProduct(prod);
        if (p == null) {
            cad = "No se pudo añadir";
        } else {
            factura.agregarProducto(p);
            System.out.println(factura.getProducts());
            cad = "Se añadio exitosamente";
        }
        return cad;
    }

}
