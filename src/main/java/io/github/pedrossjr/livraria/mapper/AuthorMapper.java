package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.AuthorDTO;
import io.github.pedrossjr.livraria.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "dateDeath", source = "dateDeath", dateFormat = "dd-MM-yyyy")
    Author toModel(AuthorDTO authorDTO);
    AuthorDTO toDTO(Author author);

}
