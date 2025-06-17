package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
