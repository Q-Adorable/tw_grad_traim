package com.example.tw_mall.service;

import com.example.tw_mall.entity.Goods;
import com.example.tw_mall.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> getAllGoods(){
        List<Goods> list=new ArrayList<Goods>();
        list=goodsRepository.findAll();
        return list;
    }

    public Goods showOneGoodsById(int id){
        Goods goods=null;
        try{
            goods=goodsRepository.findById(id).get();
        }catch (Exception e){}
        return goods;
    }

    public boolean addGoods(Goods goods){

        int preSize=goodsRepository.findAll().size();
        goodsRepository.save(goods);
        int nowSize=goodsRepository.findAll().size();
        if((nowSize-preSize)==1){
            return true;
        }
        return false;
    }

    public boolean updateGoods(int id,String name){
        Goods goods=goodsRepository.findById(id).get();
        if(goods!=null){
            goods.setName(name);
            goodsRepository.save(goods);
            return true;
        };
        return false;
    }

    public List<Goods> filterByPrice(double minPrice,double maxPrice){
        if(minPrice>maxPrice){
            double price=minPrice;
            minPrice=maxPrice;
            maxPrice=price;
        }
        return goodsRepository.findByPriceBetween(minPrice,maxPrice);
    }

    public List<Goods> filterByBrand(String brand){
        return goodsRepository.findByBrand(brand);
    }

    public List<Goods> filterByType(String type){
        return goodsRepository.findByType(type);
    }

    public List<Goods> findOrderByPriceAsc(){
        return goodsRepository.findGoodsOrderByPriceAsc();
    }

    public List<Goods> findOrderByPriceDesc(){
        return goodsRepository.findGoodsOrderByPriceDesc();
    }

//    public List<Goods> findAll(String type, int pageSize, int pageNum, String order) {
//
//    }


}
