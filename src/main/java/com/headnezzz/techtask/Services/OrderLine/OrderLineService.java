package com.headnezzz.techtask.Services.OrderLine;

import com.headnezzz.techtask.Entity.Order;
import com.headnezzz.techtask.Entity.OrderLine;

import java.util.Collection;
import java.util.Optional;

public interface OrderLineService {
    OrderLine add(OrderLine orderLine);

    OrderLine update(OrderLine newOrderLine, Long id);

    void delete(Long id);

    Collection<OrderLine> getAll();

    Optional<OrderLine> getById(Long id);
}
