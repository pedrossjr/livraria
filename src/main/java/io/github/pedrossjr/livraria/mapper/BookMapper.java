package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toModel(BookDTO bookDTO);
    BookDTO toDTO(Book book);

}
