package com.nttdata.orden_ms.mapper;

import com.nttdata.orden_ms.model.dto.OrderDto;
import com.nttdata.orden_ms.model.dto.OrderSaveRequestDto;
import com.nttdata.orden_ms.model.dto.OrderSaveResponseDto;
import com.nttdata.orden_ms.model.dto.OrderUpdateRequestDto;
import com.nttdata.orden_ms.model.entity.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { OrderDetailMapper.class })
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto map(Order order);

    List<OrderDto> map(List<Order> orders);

    Order toEntity(OrderSaveRequestDto orderSaveRequestDto);

    Order toEntity(OrderUpdateRequestDto orderUpdateRequestDto);

    OrderSaveResponseDto toOrderSaveResponseDto(Order order);

    @AfterMapping
    default void setUserInfo(Order order, @MappingTarget OrderDto dto) {
        if (order.getUser() != null) {
            dto.setUserId(order.getUser().getId());
        }
    }

}
