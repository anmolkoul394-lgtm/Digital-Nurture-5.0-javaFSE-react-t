package com.dn5.week3.mapper;

import com.dn5.week3.controller.BookController;
import com.dn5.week3.dto.BookResponseDTO;
import com.dn5.week3.entity.Book;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Module 7 -> "RESTful HATEOAS" subtopic.
 * Adds "self" and "all-books" hypermedia links to every book resource so
 * clients can navigate the API without hard-coding URLs.
 */
@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookResponseDTO> {

    private final BookMapper bookMapper;

    public BookModelAssembler(BookMapper bookMapper) {
        super(BookController.class, BookResponseDTO.class);
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponseDTO toModel(Book book) {
        BookResponseDTO dto = bookMapper.toResponseDto(book);
        dto.add(linkTo(methodOn(BookController.class).getById(book.getId())).withSelfRel());
        dto.add(linkTo(methodOn(BookController.class).getAll()).withRel("all-books"));
        return dto;
    }
}
