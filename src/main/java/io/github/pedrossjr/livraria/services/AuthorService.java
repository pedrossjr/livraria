package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.AuthorDTO;
import io.github.pedrossjr.livraria.entities.Author;
import io.github.pedrossjr.livraria.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private ModelMapper modelMapper;

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO salvar(AuthorDTO authorDTO){
        Author author = new Author();

        author.setAuthorName(authorDTO.getAuthorName());
        author.setAuthorMail(authorDTO.getAuthorMail());
        author.setBirthDate(authorDTO.getBirthDate());
        author.setDateDeath(authorDTO.getDateDeath());

        Author authorInserido = authorRepository.save(author);

        AuthorDTO responseDTO = modelMapper.map(authorInserido, AuthorDTO.class);

        return responseDTO;

    }
}
