package com.dn5.week3.controller;

import com.dn5.week3.dto.BookRequestDTO;
import com.dn5.week3.dto.BookResponseDTO;
import com.dn5.week3.entity.Book;
import com.dn5.week3.mapper.BookModelAssembler;
import com.dn5.week3.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Module 7 -> "Building a Simple REST Controller" + "Request and Response
 * Handling" + "RESTful CRUD Operations" + "RESTful HATEOAS" +
 * "Content Negotiation and Media Types" + "Documenting RESTful APIs".
 *
 * produces = {JSON, XML} lets clients pick a representation via the
 * Accept header or ?mediaType=xml (configured in application.properties),
 * covering content negotiation end to end.
 *
 * BookResponseDTO itself extends RepresentationModel, so it doubles as its
 * own HATEOAS model - no extra EntityModel<> wrapper is needed.
 */
@Tag(name = "Books", description = "CRUD + HATEOAS endpoints for the book catalog")
@RestController
@RequestMapping(value = "/api/books", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class BookController {

    private final BookService bookService;
    private final BookModelAssembler assembler;

    public BookController(BookService bookService, BookModelAssembler assembler) {
        this.bookService = bookService;
        this.assembler = assembler;
    }

    @Operation(summary = "Create a new book")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookRequestDTO dto) {
        Book saved = bookService.create(dto);
        BookResponseDTO model = assembler.toModel(saved);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, model.getRequiredLink("self").getHref())
                .header("X-Resource-Type", "Book")
                .body(model);
    }

    @Operation(summary = "Get all books (HATEOAS collection)")
    @GetMapping
    public CollectionModel<BookResponseDTO> getAll() {
        List<BookResponseDTO> books = bookService.findAll().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).getAll()).withSelfRel());
    }

    @Operation(summary = "Get a book by id")
    @GetMapping("/{id}")
    public BookResponseDTO getById(@PathVariable Long id) {
        return assembler.toModel(bookService.findById(id));
    }

    @Operation(summary = "Update an existing book (optimistic locking on version)")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookResponseDTO update(@PathVariable Long id, @Valid @RequestBody BookRequestDTO dto) {
        return assembler.toModel(bookService.update(id, dto));
    }

    @Operation(summary = "Delete a book")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search books by author (query parameter)")
    @GetMapping("/search")
    public List<Book> byAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }
}
