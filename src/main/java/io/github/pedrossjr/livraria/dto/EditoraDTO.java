package io.github.pedrossjr.livraria.dto;

import io.github.pedrossjr.livraria.entities.Editora;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditoraDTO {

    private Long id;
    private String nomeEditora;
    private String emailEditora;

    public EditoraDTO(Editora entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
