package com.headnezzz.techtask.Controllers.Order;


import com.headnezzz.techtask.Dto.GoodsDto;
import com.headnezzz.techtask.Dto.OrderDto;
import com.headnezzz.techtask.Entity.Goods;
import com.headnezzz.techtask.Entity.Order;
import com.headnezzz.techtask.Entity.OrderLine;
import com.headnezzz.techtask.Exceptions.OrderNotFoundException;
import com.headnezzz.techtask.Services.Order.OrderService;
import com.headnezzz.techtask.Services.OrderLine.OrderLineService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;
    private final OrderLineService orderLineService;

    @Autowired
    public OrderController(OrderService orderService, OrderLineService orderLineService) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
    }

    @PostMapping
    public void createOrder() {
//        OrderLine orderLine = new OrderLine();
//        Goods goods = new Goods(orderLine);
//        Goods goods1 = new Goods(orderLine);
//        Set<Goods> goodsSet = new HashSet<>();
//        goodsSet.add(goods1);
//        goodsSet.add(goods);
//        orderLine.setGoods(goodsSet);
//        orderService.add(new Order(1l, "123", LocalDateTime.now(), "123", new HashSet<>(Collections.singletonList(orderLine))));
//        Order order = new Order();
//        order.setAddress(form.getAddress());
//        order.setClient(form.getClient());
//        order.setDate(form.getDate());
//
//        for (GoodsDto goodsDto:form.getGoods()) {
//            OrderLine orderLine = new OrderLine();
//        }
        //return ResponseEntity.status(HttpStatus.CREATED).body(orderService.add(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order newOrder) {
        return ResponseEntity.accepted().body(orderService.update(newOrder, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection<OrderLine>> getOrder(@PathVariable Long id) {
        Order order = orderService.add(new Order("test",LocalDateTime.now(),"test"));
        orderLineService.add(new OrderLine(1L, order, 11));
        return ResponseEntity.ok(orderLineService.getAll());
    }
}
