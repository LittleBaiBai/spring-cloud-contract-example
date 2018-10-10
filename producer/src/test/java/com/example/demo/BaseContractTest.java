package com.example.demo;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class BaseContractTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new KittensController());
    }
}
