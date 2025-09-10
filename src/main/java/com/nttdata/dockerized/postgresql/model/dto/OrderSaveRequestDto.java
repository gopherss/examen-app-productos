package com.nttdata.dockerized.postgresql.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSaveRequestDto {
    private Long userId;
    private List<OrderDetailRequestDto> details;
}
