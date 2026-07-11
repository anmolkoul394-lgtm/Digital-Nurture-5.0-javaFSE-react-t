package com.dn5.week3.mapper;

import com.dn5.week3.dto.BookRequestDTO;
import com.dn5.week3.dto.BookResponseDTO;
import com.dn5.week3.entity.Book;
import org.springframework.stereotype.Component;

/**
 * Module 7 -> "RESTful Resource Representation with DTOs" subtopic:
 * "Mapping entities to DTOs".
 */
@Component
public class BookMapper {

    public Book toEntity(BookRequestDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setStock(dto.getStock());
        return book;
    }

    public void updateEntity(Book book, BookRequestDTO dto) {
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setStock(dto.getStock());
    }

    public BookResponseDTO toResponseDto(Book book) {
        return new BookResponseDTO(
                book.getId(), book.getTitle(), book.getAuthor(),
                book.getIsbn(), book.getPrice(), book.getStock());
    }
}
