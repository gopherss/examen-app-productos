package com.nttdata.stock_ms.model.dto;

import lombok.Data;

@Data
public class FindByProductIdDto {
    private Integer productId;
    private Integer total;
}
