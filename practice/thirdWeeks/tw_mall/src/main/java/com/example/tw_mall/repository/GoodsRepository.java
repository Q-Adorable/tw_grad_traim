package com.example.tw_mall.repository;

import com.example.tw_mall.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    List<Goods> findByPriceBetween(double minPrice,double maxPrice);

    List<Goods> findByBrand(String brand);

    List<Goods> findByType(String type);

    @Query("select g from Goods g order by g.price desc")
    List<Goods> findGoodsOrderByPriceDesc();

    @Query("select g from Goods g order by g.price")
    List<Goods> findGoodsOrderByPriceAsc();
}
