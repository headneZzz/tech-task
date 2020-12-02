package com.headnezzz.techtask.Services.Order;

import com.headnezzz.techtask.Entity.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {

    Order add(Order order);

    Order update(Order newOrder, Long id);

    void delete(Long id);

    Collection<Order> getAll();

    Optional<Order> getById(Long id);
}