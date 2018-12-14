package io.khasang.auction.controller;

import io.khasang.auction.entity.Bird;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BirdControllerIntegrationTest {
 private static final String ROOT = "http://localhost:8080/bird";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String ALL = "/getAll";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete";

    @Test
    public void addBird() {
        Bird bird = createdBird();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bird> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID +"/{id}",
                HttpMethod.GET,
                null,
                Bird.class,
                bird.getId());
        assertEquals("OK",responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(responseEntity.getBody());
         }

        private Bird createdBird() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Bird bird = prefillBird();
        HttpEntity<Bird> entity = new HttpEntity<>(bird, headers);
        RestTemplate restTemplate = new RestTemplate();
        Bird createdBird = restTemplate.exchange(ROOT + ADD, HttpMethod.POST,entity,Bird.class).getBody();
        assertNotNull(createdBird);
        assertNotNull(createdBird.getName());


        return createdBird;
    }

    @Test
    public void checkAllBird(){
        createdBird();
        createdBird();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Bird>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Bird>>(){}

        );

    }


    private Bird prefillBird() {
        Bird bird = new Bird();
        bird.setName("Keisha");
        bird.setDescription("Light-speaking");

        return bird;
    }
/*
    @Test
    public void updateBird() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bird> responseEntity = restTemplate.exchange(
                ROOT + UPDATE ,
                HttpMethod.PUT,
                null,
                Bird.class,
         //       bird.getId());
    }
*/







}



























