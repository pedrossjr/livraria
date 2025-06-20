package io.github.pedrossjr.livraria.mapper;

import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.entities.Author;
import io.github.pedrossjr.livraria.entities.Book;
import io.github.pedrossjr.livraria.entities.Gender;
import io.github.pedrossjr.livraria.entities.Publisher;
import io.github.pedrossjr.livraria.repositories.AuthorRepository;
import io.github.pedrossjr.livraria.repositories.GenderRepository;
import io.github.pedrossjr.livraria.repositories.PublisherRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toModel(BookDTO bookDTO);
    BookDTO toDTO(Book book);

    @AfterMapping
    default void resolveRelationships(BookDTO bookDTO, @MappingTarget Book book,
                                      @Autowired AuthorRepository authorRepository,
                                      @Autowired PublisherRepository publisherRepository,
                                      @Autowired GenderRepository genderRepository) {

        if (bookDTO.getAuthor() != null) {
            Author author = authorRepository.findById(bookDTO.getAuthor().getId())
                    .orElseThrow(() -> new RuntimeException("Author not found."));
            book.setAuthor(author);
        }

        if (bookDTO.getPublisher() != null) {
            Publisher publisher = publisherRepository.findById(bookDTO.getPublisher().getId())
                    .orElseThrow(() -> new RuntimeException("Publisher not found."));
            book.setPublisher(publisher);
        }

        if (bookDTO.getGender() != null) {
            Gender gender = genderRepository.findById(bookDTO.getGender().getId())
                    .orElseThrow(() -> new RuntimeException("Gender not found."));
            book.setGender(gender);
        }
    }


}
