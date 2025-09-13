package com.nttdata.stock_ms.mapper;

import com.nttdata.stock_ms.model.dto.SaveStockRequestDto;
import com.nttdata.stock_ms.model.dto.SaveStockResponseDto;
import com.nttdata.stock_ms.model.entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {
    Stock toEntity(SaveStockRequestDto saveStockRequestDto);
    SaveStockResponseDto toDto(Stock stockEntity);
}
