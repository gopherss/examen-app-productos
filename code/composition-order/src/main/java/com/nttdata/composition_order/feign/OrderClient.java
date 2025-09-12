package com.nttdata.composition_order.feign;

import com.nttdata.composition_order.dto.order.OrderDto;
import com.nttdata.composition_order.dto.order.OrderSaveRequestDto;
import com.nttdata.composition_order.dto.order.OrderSaveResponseDto;
import com.nttdata.composition_order.dto.order.OrderUpdateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "order-service", url = "http://localhost:8081/api/orders")
public interface OrderClient {

//    @GetMapping
//    List<OrderDto> getAllOrders();
//
//    @GetMapping("/{id}")
//    OrderDto getOrderById(@PathVariable("id") Long id);
//
//    @GetMapping("/user/{userId}")
//    List<OrderDto> getOrdersByUser(@PathVariable("userId") Long userId);
//
//    @PostMapping
//    OrderSaveResponseDto saveOrder(@RequestBody OrderSaveRequestDto dto);
//
//    @PutMapping("/{id}")
//    OrderDto updateOrder(@PathVariable("id") Long id, @RequestBody OrderUpdateRequestDto dto);
//
//    @DeleteMapping("/{id}")
//    void deleteOrder(@PathVariable("id") Long id);
}
