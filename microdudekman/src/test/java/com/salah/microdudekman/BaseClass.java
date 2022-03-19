package com.salah.microdudekman;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.*;
public class BaseClass {

    @BeforeAll
    static void setup(){
        RestAssuredMockMvc.standaloneSetup(new ProviderController());
    }
}
