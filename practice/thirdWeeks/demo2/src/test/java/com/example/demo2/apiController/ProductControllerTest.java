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
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Test
    @DatabaseSetup("classpath:/productSampleData.xml")
    public void testProduct() {
        given()
                .port(port)
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("list.id", contains(1, 2))
                .body("list.name", contains("苹果", "香蕉"));
    }

    @Test
    @DatabaseSetup("classpath:/productSampleData.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "classpath:/expectedProductSampleData.xml")
    public void should_add_a_product() {
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new Product("test", 3, "瓶"))
                .post("/products")
                .then()
                .statusCode(201)
                .header("location", notNullValue());
    }

    @Test
    @DatabaseSetup("classpath:/productSampleData.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "classpath:/expectedUpdateProductData.xml")
    public void should_update_a_product() {
        given()
                .port(port)
                .when()
                .request()
                .contentType(ContentType.JSON)
                .body(new Product("苹果", 8, "斤"))
                .put("/products/1")
                .then()
                .statusCode(201)
                .header("location", notNullValue());
    }
}