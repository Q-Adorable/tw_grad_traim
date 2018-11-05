package com.example.providercontract;

import com.example.providercontract.controller.ProductController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class MvcTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ProductController());
    }

}

