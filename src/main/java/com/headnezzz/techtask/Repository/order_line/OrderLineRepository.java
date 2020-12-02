package com.headnezzz.techtask.Repository.order_line;

import com.headnezzz.techtask.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
