package com.products.controller;


import com.products.dto.ProductoDto;
import com.products.service.ProductoService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> findById(@PathVariable Long id){
        ProductoDto response = productoService.findProductById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ProductoDto> findById(@PathVariable String nombre){
        ProductoDto response = productoService.findProductByName(nombre);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllOrderByPrice(){
        return ResponseEntity.ok().body(productoService.findAllByPrice());
    }


    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto productoDto){
        ProductoDto response = productoService.createProduct(productoDto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> update(@PathVariable Long id, ProductoDto productoDto){
        ProductoDto response = productoService.updateProduct(id, productoDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productoService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
