package dev.danvega.rc.interceptors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SimpleInterceptorClientTest {

    @Autowired
    SimpleInterceptorClient simpleInterceptorClient;

    @Test
    void findAllTodos() {
        String todos = simpleInterceptorClient.findAllTodos();
        assertNotNull(todos);
    }
}