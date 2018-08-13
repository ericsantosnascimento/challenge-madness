package com.dojo.madness.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@Transactional
public class AbilitiesControllerTest {

    @Autowired
    private AbilityController abilityController;

    @Test
    public void get_abilities_returns_200() {

        given()
                .standaloneSetup(abilityController)
                .get("/api/v1/abilities")
                .then()
                .statusCode(200)
                .body(containsString("Sleep Dart"));

    }

    @Test
    public void get_ability_biotic_rifle_returns_200() {

        given()
                .standaloneSetup(abilityController)
                .get("/api/v1/abilities/1")
                .then()
                .statusCode(200)
                .body(containsString("Biotic Rifle"));

    }
}