package com.accenture_test.models.entity;

import java.util.ArrayList;

public class Factura {

    private static Factura instance = null;
    private Cliente cliente;
    private ArrayList<Producto> products;
    private double subtotal;
    private double total;
    private final static double iva = 0.19;
    private final static double domicilio = 4000;

    private Factura () {

        this.products = new ArrayList<>();
    }

    public static Factura getInstance() {
        if(instance == null){
            instance = new Factura();
        }
        return instance;
    }

    public Factura(Cliente cli, double subtotal, double total) {
        this.cliente = cli;
        this.products = new ArrayList<>();
        this.subtotal = subtotal;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Producto> products) {
        this.products = products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public double getDomicilio() {
        return domicilio;
    }

    public void agregarProducto (Producto prod) {
        products.add(prod);
    }
}
