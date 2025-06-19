package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.AuthorDTO;
import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.entities.Author;
import io.github.pedrossjr.livraria.entities.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Objects;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "dateDeath", source = "dateDeath", dateFormat = "dd-MM-yyyy")
    Author toModel(AuthorDTO authorDTO);
    AuthorDTO toDTO(Author author);

    Book toModel(BookDTO bookDTO);
    BookDTO toDTO(Book book);

    @AfterMapping
    default void linkBooks(@MappingTarget Author author) {
        Optional.ofNullable(author.getBooks())
                .ifPresent(books -> books.stream()
                        .filter(Objects::nonNull)
                        .forEach(book -> book.setAuthor(author)));
    }

}
