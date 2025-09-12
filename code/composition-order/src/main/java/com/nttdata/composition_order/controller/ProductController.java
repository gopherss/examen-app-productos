package com.nttdata.composition_order.controller;

import com.nttdata.composition_order.dto.order.ProductDto;
import com.nttdata.composition_order.dto.order.ProductSaveRequestDto;
import com.nttdata.composition_order.dto.order.ProductSaveResponseDto;
import com.nttdata.composition_order.dto.order.ProductUpdateRequestDto;
import com.nttdata.composition_order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composition/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductSaveResponseDto saveProduct(@RequestBody ProductSaveRequestDto dto){
        return productService.saveProduct(dto);
    }

    @PutMapping("/{id}")
    ProductDto updateProduct(@PathVariable Long id,
                             @RequestBody ProductUpdateRequestDto dto){
        return  productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}