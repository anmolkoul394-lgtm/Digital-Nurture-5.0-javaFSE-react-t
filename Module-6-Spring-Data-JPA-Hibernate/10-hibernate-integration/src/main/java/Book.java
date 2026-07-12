// Book.java
// @CreationTimestamp is a Hibernate-specific annotation (org.hibernate.annotations),
// as opposed to Spring Data's @CreatedDate used in the auditing topic - Hibernate
// sets this itself, no @EnableJpaAuditing or AuditorAware bean required.
// @DynamicUpdate makes Hibernate's UPDATE statement include only changed columns.

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@DynamicUpdate
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Book() {}
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
