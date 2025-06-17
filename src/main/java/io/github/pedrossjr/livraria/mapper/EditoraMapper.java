package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.EditoraDTO;
import io.github.pedrossjr.livraria.entities.Editora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditoraMapper {

    EditoraMapper INSTANCE = Mappers.getMapper(EditoraMapper.class);

    // Para usar na entidade Autor
    // @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy");
     Editora toModel(EditoraDTO editoraDTO);

     EditoraDTO toDTO(Editora editora);
}
