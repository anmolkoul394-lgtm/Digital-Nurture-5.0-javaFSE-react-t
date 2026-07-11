package com.dn5.week3.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

/**
 * Module 7 -> "RESTful Resource Representation with DTOs" +
 * "RESTful HATEOAS" + "Content Negotiation and Media Types".
 *
 * - Extends RepresentationModel so HATEOAS links (self, all-books, ...)
 *   can be attached by BookModelAssembler.
 * - @JacksonXmlRootElement lets this same DTO be rendered as either
 *   JSON or XML depending on the Accept header / ?mediaType param.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "book")
public class BookResponseDTO extends RepresentationModel<BookResponseDTO> {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer stock;
}
