package com.accenture_test.models.service;

import com.accenture_test.models.entity.Cliente;
import com.accenture_test.models.entity.Factura;
import com.accenture_test.models.entity.Producto;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private Factura factura;
    private ProductoService prodService;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaService(){
        factura = Factura.getInstance();
        factura.setCliente(new Cliente("1093141512", "Atalaya parte baja"));
    }

    public void calcularTotal(){
        int aux = 0;
        if(factura.getSubtotal() > 70000 && factura.getSubtotal() < 100000){
            aux += factura.getSubtotal() * factura.getIva();
            factura.setTotal(factura.getSubtotal() + aux  + factura.getDomicilio()) ;
        } else if (factura.getSubtotal() > 100000) {
            aux += factura.getSubtotal() * factura.getIva();
            factura.setTotal(factura.getSubtotal() + aux) ;
        }
    }

    public void subTotal(){
        int aux = 0;
        for(int i = 0; i < factura.getProducts().size(); i ++) {
            aux += factura.getProducts().get(i).getPrecio();
        }
        factura.setSubtotal(aux);
    }

    public String addProducto(String prod){
        String cad = "";
        prodService = new ProductoService();
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
