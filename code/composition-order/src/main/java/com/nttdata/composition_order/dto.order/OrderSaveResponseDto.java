package com.nttdata.composition_order.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderSaveResponseDto {
    private Long id;
    private String status;
    private Long userId;
//    private List<OrderDetailDto> details;
}
