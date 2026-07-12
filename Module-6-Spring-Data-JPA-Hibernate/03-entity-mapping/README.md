# Entity Mapping

An **entity** is a plain Java class that JPA maps onto a database table - one row per
object, one column per field (roughly).

## Core annotations

- `@Entity` - marks the class as a JPA entity
- `@Table(name = "...")` - optional, overrides the default table name (which would
  otherwise just be the class name)
- `@Id` - marks the primary key field
- `@GeneratedValue(strategy = GenerationType.IDENTITY)` - lets the database auto-increment
  the id, instead of you assigning it manually
- `@Column(name = "...", nullable = false, length = 100)` - customizes a column's name/constraints
- Relationship annotations - `@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@OneToOne` -
  map object references onto foreign keys

## The example used in this module

Two related entities: a `Book` belongs to an `Author` (many books, one author - a
classic `@ManyToOne` / `@OneToMany` pair).

```
Author (1) ----< (many) Book
```

## Files

- `src/main/java/Author.java` - the "one" side, has a list of books.
- `src/main/java/Book.java` - the "many" side, has a reference back to its author.

These two classes get reused (and extended) by every remaining topic in this module.

## What to notice

- `mappedBy = "author"` on the `Author` side tells Hibernate that the `Book` entity
  already owns the foreign key column - `Author` doesn't need its own column for this,
  it just reflects the relationship.
- `@JoinColumn(name = "author_id")` on the `Book` side is what actually creates the
  foreign key column in the `book` table.

Reference: https://salithachathuranga94.medium.com/object-relational-mapping-with-spring-boot-jpa-and-hibernate-18cdfc51b4f0
