package com.nttdata.composition_order.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequestDto {

    private String name;
    private Double price;
    private Long categoryId;
}
