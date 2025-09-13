package com.nttdata.stock_ms.model.dto;

import lombok.Data;

@Data
public class SaveStockResponseDto {
    private Integer id;
    private Integer productId;
    private Integer wareHouseId;
    private Integer quantity;
}
