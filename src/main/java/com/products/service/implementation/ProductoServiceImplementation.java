package com.products.service.implementation;

import com.products.dto.ProductoDto;
import com.products.entity.Producto;
import com.products.repository.ProductoRepository;
import com.products.service.ProductoService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImplementation implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImplementation(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDto createProduct(ProductoDto productoDto) {
        Producto producto = new Producto(productoDto);
        Producto productoSaved = productoRepository.save(producto);
        ProductoDto response = new ProductoDto(productoSaved);
        return response;
    }

    @Override
    public ProductoDto updateProduct(Long id, ProductoDto productoDto) {
        Optional<Producto> producto = productoRepository.findById(id);
        ProductoDto response = new ProductoDto();
        if(producto.isPresent()) {
            Producto productoUpdated = productoRepository.save(producto.get());
            response = new ProductoDto(productoUpdated);
        }
        return response;
    }

    @Override
    public ProductoDto findProductById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isPresent()) {
            return new ProductoDto(producto.get());
        }
        return null;
    }

    @Override
    public ProductoDto findProductByName(String name) {
        Optional<Producto> producto = productoRepository.findByNombre(name);
        if(producto.isPresent()) {
            return new ProductoDto(producto.get());
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDto> findAllByPrice() {
        List<Producto> productList = productoRepository.findAllByOrderByPrecio();
        List<ProductoDto> response = new ArrayList<ProductoDto>();
        for (Producto product: productList) {
            response.add(new ProductoDto(product));
        }
        return response;
    }
}
