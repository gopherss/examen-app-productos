package com.nttdata.composition_order.service;

import com.nttdata.composition_order.dto.order.ProductDto;
import com.nttdata.composition_order.dto.order.ProductSaveRequestDto;
import com.nttdata.composition_order.dto.order.ProductSaveResponseDto;
import com.nttdata.composition_order.dto.order.ProductUpdateRequestDto;
import com.nttdata.composition_order.feign.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    public List<ProductDto> getAllProducts(){
        return productClient.getAllProducts();
    }

    public ProductDto getProductById( Long id){
        return productClient.getProductById(id);
    }

    public ProductSaveResponseDto saveProduct(ProductSaveRequestDto dto){
        return productClient.saveProduct(dto);
    }

    public ProductDto updateProduct(Long id, ProductUpdateRequestDto dto){
        return productClient.updateProduct(id, dto);
    }

    public void deleteProduct(Long id){
        productClient.deleteProduct(id);
    }

}
