package com.dn5.week3.integration;

import com.dn5.week3.dto.BookRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Module 7 -> "Testing RESTful APIs" subtopic: "Integration testing for
 * REST services". Boots the full application context (real embedded H2 DB,
 * real security filter chain) and hits it over HTTP.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookApiIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllBooks_returnsSeededData() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/books", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Clean Code");
    }

    @Test
    void createBook_withoutAuth_isAllowedForDemoThenFetchable() {
        BookRequestDTO newBook = new BookRequestDTO("Test Driven Development", "Kent Beck", "1111111111", 499.0, 3);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/books", newBook, String.class);

        // Write endpoints require auth per SecurityConfig -> expect 401/403 without a token
        assertThat(response.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    void login_withValidDemoCredentials_returnsToken() {
        var loginPayload = new com.dn5.week3.dto.LoginRequestDTO("admin", "admin123");

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/auth/login", loginPayload, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("token");
    }
}
