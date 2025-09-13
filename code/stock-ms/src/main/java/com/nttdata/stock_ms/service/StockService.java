package com.nttdata.stock_ms.service;


import com.nttdata.stock_ms.model.dto.FindByProductIdDto;
import com.nttdata.stock_ms.model.dto.SaveStockRequestDto;
import com.nttdata.stock_ms.model.dto.SaveStockResponseDto;

import java.util.List;

public interface StockService {

    List<SaveStockResponseDto> saveStock(List<SaveStockRequestDto> requestDto);

    FindByProductIdDto getStockByProductId(Integer productId);

}
