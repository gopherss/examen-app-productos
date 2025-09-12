package com.nttdata.product_ms.mapper;


import com.nttdata.product_ms.model.dto.ProductDto;
import com.nttdata.product_ms.model.dto.ProductSaveRequestDto;
import com.nttdata.product_ms.model.dto.ProductSaveResponseDto;
import com.nttdata.product_ms.model.dto.ProductUpdateRequestDto;
import com.nttdata.product_ms.model.entity.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto map(Product product);

    List<ProductDto> map(List<Product> products);

    Product toEntity(ProductSaveRequestDto productSaveRequestDto);

    Product toEntity(ProductUpdateRequestDto productUpdateRequestDto);

    ProductSaveResponseDto toProductSaveResponseDto(Product product);

    @AfterMapping
    default void setCategoryInfo(Product product, @MappingTarget ProductDto productDto) {
        if (product.getCategory() != null) {
            productDto.setCategoryId(product.getCategory().getId());
            productDto.setCategoryName(product.getCategory().getName());
        }
    }
}
