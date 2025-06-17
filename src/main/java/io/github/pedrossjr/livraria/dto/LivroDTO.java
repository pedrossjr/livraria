package io.github.pedrossjr.livraria.dto;

import io.github.pedrossjr.livraria.entities.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroDTO {

    private String isbn;
    private String tituloLivro;
    private String descricaoLivro;
    private int numeroPaginas;

    public LivroDTO(Livro entity) {
        BeanUtils.copyProperties(entity, this);
    }

}