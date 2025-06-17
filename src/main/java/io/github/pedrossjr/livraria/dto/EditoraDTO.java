package io.github.pedrossjr.livraria.dto;

import io.github.pedrossjr.livraria.entities.Editora;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditoraDTO {

    private Long id;

    @NotEmpty(message = "{campo.nome-editora.obrigatorio}")
    private String nomeEditora;

    @NotEmpty(message = "{campo.email-editora.obrigatorio}")
    private String emailEditora;

    public EditoraDTO(Editora entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
