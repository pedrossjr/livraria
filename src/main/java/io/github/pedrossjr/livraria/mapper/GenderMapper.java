package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.GenderDTO;
import io.github.pedrossjr.livraria.entities.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    Gender toModel(GenderDTO genderDTO);
    GenderDTO toDTO(Gender gender);

}
