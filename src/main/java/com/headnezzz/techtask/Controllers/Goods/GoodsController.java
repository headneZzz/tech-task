package com.headnezzz.techtask.Controllers.Goods;


import com.headnezzz.techtask.Entity.Goods;
import com.headnezzz.techtask.Exceptions.GoodsNotFoundException;
import com.headnezzz.techtask.Services.Goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/goods")
@CrossOrigin
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping
    public ResponseEntity<Goods> createGoods(@RequestBody Goods newGoods) {
        return ResponseEntity.status(HttpStatus.CREATED).body(goodsService.add(newGoods));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods newGoods) {
        return ResponseEntity.accepted().body(goodsService.update(newGoods, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Goods> deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Goods>> getAllGoods() {
        return ResponseEntity.ok(goodsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable Long id) {
        return ResponseEntity
                .ok(goodsService.getById(id).orElseThrow(() -> new GoodsNotFoundException(id)));
    }
}
