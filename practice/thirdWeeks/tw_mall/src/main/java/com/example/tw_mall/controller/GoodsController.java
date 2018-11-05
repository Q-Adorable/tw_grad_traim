package com.example.tw_mall.controller;

import com.example.tw_mall.entity.Goods;
import com.example.tw_mall.repository.GoodsRepositoryImpl;
import com.example.tw_mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsRepositoryImpl goodsRepositoryImpl;

    @GetMapping
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }

    @GetMapping(params = {"id"})
    public Goods showOneGoodsInfoById(@PathVariable int id){
        return goodsService.showOneGoodsById(id);
    }

    @PostMapping
    public boolean addGoods(@RequestBody Goods goods){
        return goodsService.addGoods(goods);
    }

    @PutMapping("/{id}")
    public boolean updateGoods(@PathVariable int id,@RequestBody String name){
        return goodsService.updateGoods(id,name);
    }

//    @GetMapping
//    public List<Goods> findAll(@RequestParam(value = "pageSize",defaultValue = "2") int pageSize,
//                              @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
//                              @RequestParam(value = "type",defaultValue ="") String type,
//                              @RequestParam(value = "order",required = false) String order){
//        return goodsService.findAll(type,pageSize,pageNum,order);
//
//    }

    @GetMapping("/test")
    public List<Goods> findAll(@RequestParam(value = "type",defaultValue = "") String type,
                               @RequestParam(value = "minPrice",defaultValue = "") double minPrice,
                               @RequestParam(value = "maxPrice",defaultValue = "") double maxPrice){
        return goodsRepositoryImpl.filter(type,minPrice,maxPrice);
    }



    @GetMapping(params = {"minPrice","maxPrice"})
    public List<Goods> filterByPrice(@RequestParam double minPrice,double maxPrice){
        return goodsService.filterByPrice(minPrice,maxPrice);
    }

    @GetMapping(params = {"brand"})
    public List<Goods> filterByBrand(String brand){
        return goodsService.filterByBrand(brand);
    }

    @GetMapping(params = {"type"})
    public List<Goods> filterByType(String type){
        return goodsService.filterByType(type);
    }

    @GetMapping("/ascByPrice")
    public List<Goods> findOrderByPriceAsc(){
        return goodsService.findOrderByPriceAsc();
    }

    @GetMapping("/descByPrice")
    public List<Goods> findOrderByPriceDesc(){
        return goodsService.findOrderByPriceDesc();
    }
}
