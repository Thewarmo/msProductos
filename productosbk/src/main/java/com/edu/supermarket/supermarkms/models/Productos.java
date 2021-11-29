package com.edu.supermarket.supermarkms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Productos {

    @Id
    private Integer idProducto;
    private String nombre_producto;
    private Double precio;
    private Integer cantidad;
    private String imagen;


    public Productos(Integer idProducto, String nombre_producto, Double precio, Integer cantidad,String imagen) {
        this.idProducto = idProducto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
