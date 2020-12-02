package com.headnezzz.techtask.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "client",nullable = false)
    private String client;

    @Column(name = "date",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @Column(name = "address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "order", fetch=FetchType.EAGER)
    private Collection<OrderLine> orderLines;

    public Order(String client, LocalDateTime date, String address) {
        this.client = client;
        this.date = date;
        this.address = address;
    }
}
