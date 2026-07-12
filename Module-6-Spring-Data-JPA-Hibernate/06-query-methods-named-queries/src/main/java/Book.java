// Book.java
// Includes a @NamedQuery, defined once on the entity and referenced by name
// from the repository (see BookRepository.findExpensiveBooksNamedQuery).

import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "Book.findExpensive",
        query = "SELECT b FROM Book b WHERE b.price > :threshold"
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;

    public Book() {}
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return title;
    }
}
