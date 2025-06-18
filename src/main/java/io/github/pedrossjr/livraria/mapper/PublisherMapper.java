package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

     Publisher toModel(PublisherDTO publisherDTO);

     PublisherDTO toDTO(Publisher publisher);
}
