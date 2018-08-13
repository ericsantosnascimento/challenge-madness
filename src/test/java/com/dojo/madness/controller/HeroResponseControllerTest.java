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
public class HeroResponseControllerTest {

    @Autowired
    private HeroController heroController;

    @Test
    public void get_heroes_returns_200() {

        given()
                .standaloneSetup(heroController)
                .get("/api/v1/heroes")
                .then().statusCode(200)
                .body(containsString("anton"));
    }

    @Test
    public void get_hero_eric_returns_200() {

        given()
                .standaloneSetup(heroController)
                .get("/api/v1/heroes/1")
                .then()
                .statusCode(200)
                .body(containsString("eric"));

    }

    @Test
    public void get_hero_abilities_returns_200() {

        given()
                .standaloneSetup(heroController)
                .get("/api/v1/heroes/1/abilities")
                .then()
                .statusCode(200)
                .body(containsString("Biotic Rifle"));

    }
}