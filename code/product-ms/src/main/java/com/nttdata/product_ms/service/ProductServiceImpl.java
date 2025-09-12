package com.nttdata.product_ms.service;


import com.nttdata.product_ms.exception.BadRequestException;
import com.nttdata.product_ms.exception.NotFoundException;
import com.nttdata.product_ms.model.entity.Product;
import com.nttdata.product_ms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado","404"));
    }

    @Override
    public Product save(Product product) {
        if (product.getName() == null || product.getName().isBlank()){
            throw new BadRequestException("El nombre es obligatorio");
        }
        if (product.getPrice() == null || product.getPrice().isNaN()){
            throw  new BadRequestException("El precio debe ser un número y es obligatorio");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateById(Long id, Product product) {
        return productRepository.findById(id)
                .map(productExisting -> {
                    productExisting.setName(product.getName());
                    productExisting.setCategory(product.getCategory());
                    productExisting.setPrice(product.getPrice());
                    return productRepository.save(productExisting);
                }).orElseThrow(() -> new NotFoundException("Producto no encontrado para actualizar", "404"));
    }

    @Override
    public void deleteById(Long id) {
        if (!productRepository.existsById(id)){
            throw new NotFoundException("Producto no encontrado", "404");
        }
        productRepository.deleteById(id);
    }
}
