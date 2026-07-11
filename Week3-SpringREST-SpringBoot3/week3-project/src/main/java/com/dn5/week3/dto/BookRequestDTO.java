package com.dn5.week3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Module 7 -> "RESTful Resource Representation with DTOs" subtopic.
 * Clients never send/receive the raw JPA entity — they send this DTO.
 * This decouples the public API contract from the internal DB schema and
 * lets us validate incoming data with annotations before it touches
 * persistence.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @Positive(message = "Price must be positive")
    private Double price;

    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;
}
