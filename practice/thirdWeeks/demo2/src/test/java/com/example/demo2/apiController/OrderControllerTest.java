package com.example.demo2.apiController;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Test
    @DatabaseSetup("classpath:/orderItemSampleData.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "classpath:/expectedAddOrderItemData.xml")
    public void should_add_a_orderItem() {
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new AddProductRequest(2))
                .post("/orders/1/orderItems")
                .then()
                .statusCode(201)
                .header("location", notNullValue());

    }

    @Test
    @DatabaseSetup("classpath:/orderSampleData.xml")
    public void should_get_a_order_by_id() {
        given()
                .port(port)
                .when()
                .get("/orders/1")
                .then()
                .statusCode(200)
                .body("list.product.name", contains("苹果"));
    }

    @Test
    @DatabaseSetup("classpath:/orderSampleData.xml")
    @DatabaseSetup("classpath:/orderItemSampleData.xml")
    @ExpectedDatabase("classpath:/expectedAddOrderItemData.xml")
    public void should_add_a_order() {
        List<AddOrderItemRequest> list=new ArrayList<AddOrderItemRequest>();
        list.add(new AddOrderItemRequest(2,1));
        AddOrderRequest addOrderRequest=new AddOrderRequest(list);
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(addOrderRequest)
                .post("/orders")
                .then()
                .statusCode(201)
                .header("location", notNullValue());

    }

}