package com.headnezzz.techtask.Services.Goods;

import com.headnezzz.techtask.Entity.Goods;


import java.util.Collection;
import java.util.Optional;

public interface GoodsService {

    Goods add(Goods goods);

    Goods update(Goods newGoods, Long id);

    void delete(Long id);

    Collection<Goods> getAll();

    Optional<Goods> getById(Long id);
}
