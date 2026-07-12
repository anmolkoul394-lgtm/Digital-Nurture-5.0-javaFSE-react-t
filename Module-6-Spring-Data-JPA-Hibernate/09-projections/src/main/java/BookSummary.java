// BookSummary.java
// Class (DTO) projection - populated directly by a JPQL constructor expression
// in BookRepository.findSummaries().

public class BookSummary {
    private final String title;
    private final double price;

    public BookSummary(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + " costs " + price;
    }
}
