package com.accenture_test.models.service;

import com.accenture_test.models.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {

    List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto("1",20000,"Description"),
            new Producto("2",50000,"Description 2"),
            new Producto("3",900000,"Description 3")
    ));

    public Producto getProduct(String id) {
        for(int i = 0 ; i < productos.size(); i ++){
            if(productos.get(i).getId().equals(id)){
                return productos.get(i);
            }
        }
        return null;
    }

    public List<Producto> getAllProducts(){
        return productos;
    }
}
