package com.nttdata.dockerized.postgresql.controller;
import com.nttdata.dockerized.postgresql.model.dto.OrderDetailDto;
import com.nttdata.dockerized.postgresql.model.dto.OrderDetailRequestDto;
import com.nttdata.dockerized.postgresql.model.entity.Order;
import com.nttdata.dockerized.postgresql.model.entity.OrderDetail;
import com.nttdata.dockerized.postgresql.model.entity.Product;
import com.nttdata.dockerized.postgresql.service.OrderDetailService;
import com.nttdata.dockerized.postgresql.service.OrderService;
import com.nttdata.dockerized.postgresql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nttdata.dockerized.postgresql.mapper.OrderDetailMapper.INSTANCE;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping
    public OrderDetailDto saveOrderDetail(@RequestBody OrderDetailRequestDto orderDetailRequestDto) {
        Order order = orderService.findById(orderDetailRequestDto.getOrderId());
        Product product = productService.findById(orderDetailRequestDto.getProductId());

        OrderDetail detail = INSTANCE.toEntity(orderDetailRequestDto);
        detail.setOrder(order);
        detail.setProduct(product);

        OrderDetail saved = orderDetailService.save(detail);
        return INSTANCE.map(saved);
    }
}
