package com.example.demo2.controller;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ProductControllerTest {
    @LocalServerPort
    private int port;

    @Test
    public void testProduct() {
        given()
                .port(port)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("list.id", contains(1, 2, 3, 4, 5, 6,7,8))
                .body("list.name",contains("可口可乐","雪碧","苹果","荔枝","电池","方便面","test","test"));
    }

    @Test
    public void should_add_a_product(){
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new Product("test",3,"瓶"))
                .post("/products")
                .then()
                .statusCode(201)
                .header("location",notNullValue());
    }

    @Test
    public void should_update_a_product(){
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new Product("可口可乐",3,"瓶"))
                .put("products/1")
                .then()
                .statusCode(201)
                .header("location",notNullValue());
    }

}