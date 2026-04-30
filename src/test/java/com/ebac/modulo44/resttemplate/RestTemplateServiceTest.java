package com.ebac.modulo44.resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService service;

    @Test
    void testGetUser() {
        User user = service.getUserById(1L);
        System.out.println(user.getName());
    }
}