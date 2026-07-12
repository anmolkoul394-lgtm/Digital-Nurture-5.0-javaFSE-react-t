// BookTitleOnly.java
// Interface projection - Spring Data proxies this at runtime and only fetches
// the "title" column, not the entire Book entity.

public interface BookTitleOnly {
    String getTitle();
}
