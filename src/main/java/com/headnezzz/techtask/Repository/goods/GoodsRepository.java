package com.headnezzz.techtask.Repository.goods;

import com.headnezzz.techtask.Entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}