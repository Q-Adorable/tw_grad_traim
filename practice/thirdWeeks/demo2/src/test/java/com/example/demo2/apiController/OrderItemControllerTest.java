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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderItemControllerTest {

    @LocalServerPort
    private int port;

    @Test
    @DatabaseSetup("classpath:/orderItemSampleData.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT,value="classpath:/expectedUpdateOrderItemData.xml")
    public void should_update_a_orderItem(){
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new UpdateOrderItemRequest(2))
                .put("/orderItems/1")
                .then()
                .statusCode(201)
                .header("location",notNullValue());
    }

    @Test
    @DatabaseSetup("classpath:/orderItemSampleData.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT,value="classpath:/expectedDeleteOrderItemData.xml")
    public void should_delete_a_orderItem_by_id(){
        given()
                .port(port)
                .when()
                .delete("/orderItems/1")
                .then()
                .statusCode(204);
    }

    @Test
    @DatabaseSetup("classpath:/orderItemSampleData.xml")
    public void should_get_a_orderItem_by_id() {
        given()
                .port(port)
                .when()
                .get("/orderItems/1")
                .then()
                .statusCode(200)
                .body("orderId",equalTo(1));
    }
}