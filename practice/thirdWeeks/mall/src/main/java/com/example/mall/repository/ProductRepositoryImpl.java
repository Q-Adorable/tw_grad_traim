package com.example.mall.repository;

import com.example.mall.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

public class ProductRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> filterAll(String brand, String category, Double minPrice, Double maxPrice, int pageNum, int pageSize, String order) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();

        final CriteriaQuery<Product> query=criteriaBuilder.createQuery(Product.class);

        final Root<Product> root=query.from(Product.class);

        Predicate predicate = constructSearchCondition(brand, category, minPrice, maxPrice, criteriaBuilder, root);

        Order priceOrder = order.equals("DESC") ? criteriaBuilder.desc(root.get("price")) : criteriaBuilder.asc(root.get("price"));

        final CriteriaQuery<Product> criteriaQuery = query.where(predicate).orderBy(priceOrder);

        return entityManager.createQuery(criteriaQuery).setFirstResult(pageNum * pageSize).setMaxResults(pageSize).getResultList();
    }

    private Predicate constructSearchCondition(String brand, String category, Double minPrice, Double maxPrice, CriteriaBuilder criteriaBuilder, Root<Product> root) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (brand != null && !brand.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("brand"), brand));
        }

        if (category != null && !category.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("category"), category));
        }

        if (maxPrice != 0) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThan(root.get("price"), maxPrice));
        }

        if (minPrice != 0) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThan(root.get("price"), minPrice));
        }
        return predicate;
    }
}
