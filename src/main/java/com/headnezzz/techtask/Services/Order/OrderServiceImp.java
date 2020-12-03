package com.headnezzz.techtask.Services.Order;

import com.headnezzz.techtask.Entity.Order;
import com.headnezzz.techtask.Repository.order.OrderRepository;
import com.headnezzz.techtask.Exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order order) {
        order.setOrderId(null);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order newOrder, Long id) {
        orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        newOrder.setOrderId(id);
        return orderRepository.saveAndFlush(newOrder);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public Collection<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }
}
