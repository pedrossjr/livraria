package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
