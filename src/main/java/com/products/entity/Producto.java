package com.products.entity;

import com.products.dto.ProductoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String calidad;

    public Producto(ProductoDto productoDto) {
     this.nombre = productoDto.getNombre();
     this.descripcion = productoDto.getDescripcion();
     this.precio = productoDto.getPrecio();
     this.calidad = productoDto.getCalidad();
    }

    public Producto() {
    }
}
