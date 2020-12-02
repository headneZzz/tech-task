package com.headnezzz.techtask.Services.OrderLine;

import com.headnezzz.techtask.Entity.OrderLine;
import com.headnezzz.techtask.Exceptions.OrderNotFoundException;
import com.headnezzz.techtask.Repository.order_line.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return orderLineRepository.save(orderLine); //Вот тут не уверен что вернуть
    }

    @Override
    public OrderLine update(OrderLine newOrderLine, Long id) {
        orderLineRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        newOrderLine.setId(id);
        return orderLineRepository.saveAndFlush(newOrderLine);
    }

    @Override
    public void delete(Long id) {
        orderLineRepository.delete(orderLineRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public Collection<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public Optional<OrderLine> getById(Long id) {
        return orderLineRepository.findById(id);
    }
}
