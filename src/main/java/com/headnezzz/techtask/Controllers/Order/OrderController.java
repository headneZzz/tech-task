package com.headnezzz.techtask.Controllers.Order;


import com.headnezzz.techtask.Dto.OrderDto;
import com.headnezzz.techtask.Entity.Order;
import com.headnezzz.techtask.Entity.OrderLine;
import com.headnezzz.techtask.Exceptions.OrderNotFoundException;
import com.headnezzz.techtask.Services.Order.OrderService;
import com.headnezzz.techtask.Services.OrderLine.OrderLineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;
    private final OrderLineService orderLineService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderLineService orderLineService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderService.add(convertOrderToEntity(orderDto));
        List<OrderLine> orderLineList = orderDto.getGoods().stream().map(e -> new OrderLine(e.getId(), order, e.getCount())).collect(Collectors.toList());
        orderLineService.addAll(orderLineList);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        Order order = orderService.update(convertOrderToEntity(orderDto), id);
        //TODO: обновлять и/или добавлять лайны
        return ResponseEntity.accepted().body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        orderLineService.deleteAllByOrder(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getById(id).orElseThrow(() -> new OrderNotFoundException(id)));
    }

    private Order convertOrderToEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }
}
