package com.nttdata.product_ms.controller;


import com.nttdata.dockerized.postgresql.model.dto.ProductDto;
import com.nttdata.dockerized.postgresql.model.dto.ProductSaveRequestDto;
import com.nttdata.dockerized.postgresql.model.dto.ProductSaveResponseDto;
import com.nttdata.dockerized.postgresql.model.dto.ProductUpdateRequestDto;
import com.nttdata.dockerized.postgresql.model.entity.Category;
import com.nttdata.dockerized.postgresql.model.entity.Product;
import com.nttdata.dockerized.postgresql.service.CategoryService;
import com.nttdata.dockerized.postgresql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.nttdata.dockerized.postgresql.mapper.ProductMapper.INSTANCE;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        return INSTANCE.map(productService.listAll());
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return INSTANCE.map(product);
    }

    @PostMapping
    public ProductSaveResponseDto saveProduct(@RequestBody ProductSaveRequestDto dto) {
        Category category = categoryService.findById(dto.getCategoryId());

        Product product = INSTANCE.toEntity(dto);
        product.setCategory(category);

        Product productSaved = productService.save(product);
        return INSTANCE.toProductSaveResponseDto(productSaved);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                                    @RequestBody ProductUpdateRequestDto dto) {
        Product product = INSTANCE.toEntity(dto);
        Category category = categoryService.findById(dto.getCategoryId());

        product.setCategory(category);

        Product updated = productService.updateById(id, product);

        return INSTANCE.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
