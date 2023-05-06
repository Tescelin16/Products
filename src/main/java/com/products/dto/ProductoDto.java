package com.products.dto;

import com.products.entity.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {

    private String nombre;
    private String descripcion;
    private Double precio;
    private String calidad;

    public ProductoDto(Producto producto) {
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.calidad = producto.getCalidad();
    }
    public ProductoDto(){}
}
