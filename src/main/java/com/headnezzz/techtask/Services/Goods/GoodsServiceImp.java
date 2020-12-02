package com.headnezzz.techtask.Services.Goods;

import com.headnezzz.techtask.Entity.Goods;
import com.headnezzz.techtask.Exceptions.GoodsNotFoundException;
import com.headnezzz.techtask.Repository.goods.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GoodsServiceImp implements GoodsService{

    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsServiceImp(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods add(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods update(Goods newGoods, Long id) {
        Goods oldGoods = goodsRepository.findById(id).orElseThrow(()->new GoodsNotFoundException(id));
        oldGoods.setName(newGoods.getName());
        oldGoods.setPrice(newGoods.getPrice());
        return goodsRepository.saveAndFlush(oldGoods);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.findById(id).orElseThrow(() -> new GoodsNotFoundException(id));
        goodsRepository.deleteById(id);
    }

    @Override
    public Collection<Goods> getAll() {
        return goodsRepository.findAll();
    }

    @Override
    public Optional<Goods> getById(Long id) {
        return goodsRepository.findById(id);
    }
}
