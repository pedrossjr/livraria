package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
