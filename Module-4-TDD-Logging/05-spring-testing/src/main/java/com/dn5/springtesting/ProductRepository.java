// ProductRepository.java
// Repository layer interface - in a real app this would extend Spring Data JPA's
// JpaRepository. Kept as a plain interface here to focus purely on the testing concepts.
// See ProductRepositoryImpl.java for the (in-memory) @Repository bean implementation.

package com.dn5.springtesting;

public interface ProductRepository {
    Product findById(int id);
}
