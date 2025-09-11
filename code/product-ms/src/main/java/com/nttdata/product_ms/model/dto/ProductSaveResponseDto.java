package com.nttdata.product_ms.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveResponseDto {
    private Long id;
    private String name;
    private Double price;
}
