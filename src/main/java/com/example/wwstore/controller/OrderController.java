package com.example.wwstore.controller;

import com.example.wwstore.model.OrderEntity;
import com.example.wwstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderEntity> getAllOrders(@RequestParam("user_id") Long userId) {

        List<OrderEntity> results = orderService.getAllOrders();
        if (userId != 0L){
            return results.stream().filter(x -> x.getUser().getId().equals(userId)).toList();
        }
        return results;


    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id).orElse(null);
    }

    @PostMapping
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.placeOrder(order);
    }
    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }
}
