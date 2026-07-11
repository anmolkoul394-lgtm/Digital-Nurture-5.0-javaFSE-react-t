package com.dn5.week3.service;

import com.dn5.week3.dto.BookRequestDTO;
import com.dn5.week3.entity.Book;
import com.dn5.week3.exception.BookNotFoundException;
import com.dn5.week3.mapper.BookMapper;
import com.dn5.week3.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Module 7 -> "RESTful CRUD Operations" subtopic: business logic sits here,
 * kept separate from the controller (which only handles HTTP concerns).
 */
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Book create(BookRequestDTO dto) {
        return bookRepository.save(bookMapper.toEntity(dto));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book update(Long id, BookRequestDTO dto) {
        Book existing = findById(id);
        bookMapper.updateEntity(existing, dto);
        return bookRepository.save(existing);
    }

    public void delete(Long id) {
        Book existing = findById(id);
        bookRepository.delete(existing);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
    }
}
