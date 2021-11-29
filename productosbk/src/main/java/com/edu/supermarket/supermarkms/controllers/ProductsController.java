package com.edu.supermarket.supermarkms.controllers;

import com.edu.supermarket.supermarkms.exceptions.AccountNotFoundException;
import com.edu.supermarket.supermarkms.exceptions.ProductsNotFoundAdvice;
import com.edu.supermarket.supermarkms.exceptions.ProductsNotFoundException;
import com.edu.supermarket.supermarkms.models.Productos;
import com.edu.supermarket.supermarkms.repositories.ProductosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ProductsController {

    private final ProductosRepository productosRepository;
    public ProductsController(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }
    @GetMapping("/productos/{idProducto}")
    Productos getProductos(@PathVariable Integer idProducto){
        return productosRepository.findById(idProducto)
                .orElseThrow(() -> new AccountNotFoundException("No se encontro un producto con el id de producto: " + idProducto));
    }
    @PostMapping("/productos")
    Productos newProductos(@RequestBody Productos producto){
        return productosRepository.save(producto);
    }

    @GetMapping("/productos/all")
    public List<Productos> readAll(){
        return productosRepository.findAll();
    }

    @PutMapping("/prodAdd/{idProducto}")
    Productos replaceProducto(@RequestBody Productos newProductos, @PathVariable Integer idProducto){

        return productosRepository.findById(idProducto).map(productos -> {
            productos.setNombre_producto(newProductos.getNombre_producto());
            productos.setCantidad(newProductos.getCantidad());
            productos.setPrecio(newProductos.getPrecio());
            productos.setImagen(newProductos.getImagen());
                    return productosRepository.save(productos);
                }
        ).orElseGet(()->{
            newProductos.setIdProducto(idProducto);
            return productosRepository.save(newProductos);
        });
    }

    @DeleteMapping("/prodElim/{idProducto}")
    void deleteProductos(@PathVariable Integer idProducto){
        productosRepository.deleteById(idProducto);
    }

    @DeleteMapping("/eliminar/{idProducto}")
    public String deleteUser(
            @PathVariable(value = "idProducto") int idProducto) throws Exception {
        Productos prod = productosRepository.findById(idProducto)
                .orElseThrow(() -> new ProductsNotFoundException("Producto no encontrado :: "+ idProducto));

        productosRepository.delete(prod);
        String respuesta = new String();
        Map<String, Boolean> response = new HashMap<>();
        respuesta = "se elimino el producto"+idProducto;
        response.put("Eliminado", Boolean.TRUE);
        return respuesta;
    }
}
