package com.nttdata.composition_order.feign;


import com.nttdata.composition_order.dto.order.ProductDto;
import com.nttdata.composition_order.dto.order.ProductSaveRequestDto;
import com.nttdata.composition_order.dto.order.ProductSaveResponseDto;
import com.nttdata.composition_order.dto.order.ProductUpdateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "product-ms", url = "${product-ms.url}")
public interface ProductClient {

    @GetMapping("/api/products")
    List<ProductDto> getAllProducts();

    @GetMapping("/api/products/{id}")
    ProductDto getProductById(@PathVariable Long id);

    @PostMapping("/api/products")
    ProductSaveResponseDto saveProduct(@RequestBody ProductSaveRequestDto dto);

    @PutMapping("/api/products/{id}")
    ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody ProductUpdateRequestDto dto);

    @DeleteMapping("/api/products/{id}")
    void deleteProduct(@PathVariable Long id);

}
