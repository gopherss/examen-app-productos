package com.nttdata.stock_ms.service;

import com.nttdata.stock_ms.exception.BadRequestException;
import com.nttdata.stock_ms.exception.NotFoundException;
import com.nttdata.stock_ms.mapper.StockMapper;
import com.nttdata.stock_ms.model.dto.FindByProductIdDto;
import com.nttdata.stock_ms.model.dto.SaveStockRequestDto;
import com.nttdata.stock_ms.model.dto.SaveStockResponseDto;
import com.nttdata.stock_ms.model.entity.Stock;
import com.nttdata.stock_ms.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl  implements  StockService{

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public List<SaveStockResponseDto> saveStock(List<SaveStockRequestDto> requestDto) {
        if (requestDto == null || requestDto.isEmpty()) {
            throw new BadRequestException("La lista de stock no puede estar vacía");
        }
        requestDto.forEach(dto -> {
            if (dto.getProductId() == null) throw new BadRequestException("El id de producto es necesario");
            if (dto.getWareHouseId() == null) throw new BadRequestException("El id del almacén es necesario");
            if (dto.getQuantity() == null) throw new BadRequestException("La cantidad es necesaria");
        });

        var entities = requestDto.stream()
                .map(stockMapper::toEntity)
                .toList();

        var savedEntities = stockRepository.saveAll(entities);


        return savedEntities.stream()
                .map(stockMapper::toDto)
                .toList();
    }

    @Override
    public FindByProductIdDto getStockByProductId(Integer productId) {

        List<Stock> allStocks = stockRepository.findAll();

        List<Stock> filtered = allStocks.stream()
                .filter(stock -> stock.getProductId().equals(productId))
                .toList();
        if (filtered.isEmpty()) throw new NotFoundException("Stock no encontrado", "404");

        Integer totalQuantity = filtered.stream()
                .mapToInt(Stock::getQuantity)
                .sum();

        FindByProductIdDto findByProductIdDto = new FindByProductIdDto();
        findByProductIdDto.setProductId(productId);
        findByProductIdDto.setTotal(totalQuantity);

        return findByProductIdDto;
    }
}
