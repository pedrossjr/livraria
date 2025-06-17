package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
