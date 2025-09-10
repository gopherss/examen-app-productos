package com.nttdata.dockerized.postgresql.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailRequestDto {
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double unitPrice;
}
