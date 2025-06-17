package io.github.pedrossjr.livraria.dto;

import io.github.pedrossjr.livraria.entities.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorDTO {

    private Long id;
    private String nomeAutor;
    private String emailAutor;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;

    public AutorDTO(Autor entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
