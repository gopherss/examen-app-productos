package com.nttdata.composition_order.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;

    private Long categoryId;
    private String categoryName;
}
