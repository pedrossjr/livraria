package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
