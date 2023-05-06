package com.products.entity;

import com.products.dto.ProductoDto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
