package com.headnezzz.techtask.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Order_line")
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Long id;

    @Column(name = "goods_id")
    private Long goodsId;

    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "count")
    private int count;

    public OrderLine(Long goodsId, Order order, int count) {
        this.goodsId = goodsId;
        this.order = order;
        this.count = count;
    }
}
