package com.nttdata.stock_ms.controller;


import com.nttdata.stock_ms.model.dto.FindByProductIdDto;
import com.nttdata.stock_ms.model.dto.SaveStockRequestDto;
import com.nttdata.stock_ms.model.dto.SaveStockResponseDto;
import com.nttdata.stock_ms.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    public List<SaveStockResponseDto> saveStocks(@RequestBody List<SaveStockRequestDto> request) {
        return stockService.saveStock(request);
    }

    @GetMapping("/{productId}")
    public FindByProductIdDto getStockByProductId(@PathVariable Integer productId) {
        return stockService.getStockByProductId(productId);
    }

}
