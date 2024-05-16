package com.example.wwstore.service;

import com.example.wwstore.model.OrderEntity;
import com.example.wwstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public  OrderEntity placeOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
