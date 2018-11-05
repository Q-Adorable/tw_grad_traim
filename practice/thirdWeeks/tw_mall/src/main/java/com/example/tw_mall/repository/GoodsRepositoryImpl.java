package com.example.tw_mall.repository;

import com.example.tw_mall.entity.Goods;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public class GoodsRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Goods> filter(String type,Double minPrice,Double maxPrice){
        final CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();

        final CriteriaQuery<Goods> criteriaQuery=criteriaBuilder.createQuery(Goods.class);

        Root<Goods> goods=criteriaQuery.from(Goods.class);

        Predicate predicate=criteriaBuilder.conjunction();

        if(type!=null&&!type.equals("")){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(goods.get("type"),type));
        }
        if(minPrice!=null&&!minPrice.equals("")){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.greaterThanOrEqualTo(goods.get("price"),minPrice));
        }
        if(maxPrice!=null&&!maxPrice.equals("")){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.lessThanOrEqualTo(goods.get("price"),maxPrice));
        }
        criteriaQuery.where(predicate);
        List<Goods> list=entityManager.createQuery(criteriaQuery).getResultList();
        return list;
    }
}
