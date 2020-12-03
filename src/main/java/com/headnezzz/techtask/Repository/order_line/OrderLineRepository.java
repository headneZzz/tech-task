package com.headnezzz.techtask.Repository.order_line;

import com.headnezzz.techtask.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    void deleteAllByOrder(Long orderId);

    List<OrderLine> findAllByOrder(Long orderId);
}
