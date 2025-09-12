package com.nttdata.orden_ms.mapper;

import com.nttdata.orden_ms.model.dto.OrderDetailDto;
import com.nttdata.orden_ms.model.dto.OrderDetailRequestDto;
import com.nttdata.orden_ms.model.entity.OrderDetail;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetailDto map(OrderDetail orderDetail);

    OrderDetail toEntity(OrderDetailRequestDto dto);

    @AfterMapping
    default void setRemainingValues(OrderDetail detail, @MappingTarget OrderDetailDto dto) {
        if (detail.getOrder() != null) {
            dto.setOrderId(detail.getOrder().getId());
        }
        if (detail.getProduct() != null) {
            dto.setProductId(detail.getProduct().getId());
            dto.setProductName(detail.getProduct().getName());
        }
    }
}
