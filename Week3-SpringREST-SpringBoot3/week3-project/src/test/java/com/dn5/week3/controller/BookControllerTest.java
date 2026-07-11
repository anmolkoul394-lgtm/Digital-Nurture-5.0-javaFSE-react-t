package com.dn5.week3.controller;

import com.dn5.week3.dto.BookRequestDTO;
import com.dn5.week3.entity.Book;
import com.dn5.week3.mapper.BookMapper;
import com.dn5.week3.mapper.BookModelAssembler;
import com.dn5.week3.security.JwtAuthFilter;
import com.dn5.week3.security.JwtUtil;
import com.dn5.week3.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Module 7 -> "Testing RESTful APIs" subtopic:
 * "Unit testing REST controllers with JUnit and Mockito" +
 * "Using Spring Test and MockMvc".
 *
 * @WebMvcTest loads only the web layer (controller + its beans), and
 * @MockBean replaces the service layer so no real database is touched.
 */
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private BookModelAssembler assembler;

    // Security beans need to be mocked too since the filter chain is active
    @MockBean
    private JwtAuthFilter jwtAuthFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    @WithMockUser
    void getAll_returnsBookList() throws Exception {
        Book book = new Book(1L, "Clean Code", "Robert C. Martin", "9780132350884", 899.0, 12, 0L);
        when(bookService.findAll()).thenReturn(List.of(book));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void getById_notFound_returns404() throws Exception {
        when(bookService.findById(99L)).thenThrow(new com.dn5.week3.exception.BookNotFoundException(99L));

        mockMvc.perform(get("/api/books/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    void create_withInvalidBody_returns400() throws Exception {
        BookRequestDTO invalid = new BookRequestDTO("", "", "", -5.0, -1);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest());
    }
}
