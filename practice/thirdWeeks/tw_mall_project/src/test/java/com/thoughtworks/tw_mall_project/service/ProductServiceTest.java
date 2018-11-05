package com.thoughtworks.tw_mall_project.service;

import com.thoughtworks.tw_mall_project.entity.Product;
import com.thoughtworks.tw_mall_project.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        productService = new ProductService(productRepository);
    }

    @Test
    public void should_get_all_products_given_get_all() {
        //given
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("test1", 3.5, "type1");
        Product product2 = new Product("test2", 4, "type2");
        products.add(product1);
        products.add(product2);
        given(productRepository.findAll())
                .willReturn(products);
        //when
        List<Product> actual = productService.getAll();

        //then
        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    public void should_get_product_given_id() {
        Product product = new Product("test1", 3.5, "type1");
        Optional<Product> optProduct = Optional.of(product);
        given(productRepository.findById(anyInt())).willReturn(optProduct);

        Product actual = productService.get(1);

        assertThat(actual.getName()).isEqualTo("test1");
        assertThat(actual.getPrice()).isEqualTo(3.5);
        assertThat(actual.getType()).isEqualTo("type1");

    }

    @Test
    public void should_delete_product_given_id() {

        productService.remove(1);

        verify(productRepository, times(1)).deleteById(anyInt());

    }

    @Test
    public void should_add_product_given_product() {
        Product product = new Product("test1", 3.5, "type1");
        given(productRepository.save(product)).willReturn(product);

        Product actual = productService.add(product);

        verify(productRepository, times(1)).save(any());
        assertThat(actual.getName()).isEqualTo("test1");
        assertThat(actual.getPrice()).isEqualTo(3.5);
        assertThat(actual.getType()).isEqualTo("type1");
    }

    @Test
    public void should_update_product_given_product() {
        Product product = new Product("test1", 3.5, "type1");
        given(productRepository.save(product)).willReturn(product);
        given(productRepository.existsById(anyInt())).willReturn(true);

        Product actual1 = productService.update(anyInt(),product);

        verify(productRepository, times(1)).save(any());
        assertThat(actual1.getName()).isEqualTo("test1");
        assertThat(actual1.getPrice()).isEqualTo(3.5);
        assertThat(actual1.getType()).isEqualTo("type1");

        given(productRepository.save(product)).willReturn(product);
        given(productRepository.existsById(anyInt())).willReturn(false);

        Product actual2 = productService.update(anyInt(),product);
        assertThat(actual2).isEqualTo(null);

    }
}