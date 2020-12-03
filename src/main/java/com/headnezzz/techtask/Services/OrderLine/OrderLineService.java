package com.headnezzz.techtask.Services.OrderLine;

import com.headnezzz.techtask.Entity.Order;
import com.headnezzz.techtask.Entity.OrderLine;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OrderLineService {
    OrderLine add(OrderLine orderLine);

    List<OrderLine> addAll(List<OrderLine> orderLines);

    OrderLine update(OrderLine newOrderLine, Long id);

    void deleteById(Long id);

    void deleteAllByOrder(Long orderId);

    Collection<OrderLine> getAll();

    Collection<OrderLine> getAllByOrder(Long orderId);

    Optional<OrderLine> getById(Long id);
}
