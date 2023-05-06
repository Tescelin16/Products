package com.products.service;

import com.products.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    public ProductoDto createProduct(ProductoDto productoDto);
    public ProductoDto updateProduct(Long id, ProductoDto productoDto);
    public ProductoDto findProductById(Long id);

    public ProductoDto findProductByName(String name);
    public void deleteProduct(Long id);
    public List<ProductoDto> findAllByPrice();
}
