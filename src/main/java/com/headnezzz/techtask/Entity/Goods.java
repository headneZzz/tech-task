package com.headnezzz.techtask.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goods")
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;
}
