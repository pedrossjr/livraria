package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT COUNT(b) > 0 FROM Book b WHERE b.isbnNumber = :isbn")
    boolean existsByIsbnNumber(String isbn);

}
