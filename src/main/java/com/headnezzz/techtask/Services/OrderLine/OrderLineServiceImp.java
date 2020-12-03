package com.headnezzz.techtask.Services.OrderLine;

import com.headnezzz.techtask.Entity.OrderLine;
import com.headnezzz.techtask.Exceptions.OrderNotFoundException;
import com.headnezzz.techtask.Repository.order_line.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImp implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineServiceImp(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public OrderLine add(OrderLine orderLine) {
        orderLine.setId(null);
        return orderLineRepository.save(orderLine);
    }

    @Override
    public List<OrderLine> addAll(List<OrderLine> orderLines) {
        return orderLineRepository.saveAll(orderLines);
    }

    @Override
    public OrderLine update(OrderLine newOrderLine, Long id) {
        orderLineRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        newOrderLine.setId(id);
        return orderLineRepository.saveAndFlush(newOrderLine);
    }

    @Override
    public void deleteById(Long id) {
        orderLineRepository.deleteById(id);
    }

    @Override
    public void deleteAllByOrder(Long orderId) {
        orderLineRepository.deleteAllByOrder(orderId);
    }

    @Override
    public Collection<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public Collection<OrderLine> getAllByOrder(Long orderId) {
        return orderLineRepository.findAllByOrder(orderId);
    }

    @Override
    public Optional<OrderLine> getById(Long id) {
        return orderLineRepository.findById(id);
    }
}
