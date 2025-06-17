package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
