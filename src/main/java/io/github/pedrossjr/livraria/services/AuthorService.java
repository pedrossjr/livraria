package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.AuthorDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Author;
import io.github.pedrossjr.livraria.exception.AuthorNotFoundException;
import io.github.pedrossjr.livraria.mapper.AuthorMapper;
import io.github.pedrossjr.livraria.mapper.BookMapper;
import io.github.pedrossjr.livraria.repositories.AuthorRepository;
import io.github.pedrossjr.livraria.repositories.BookRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional
    public MessageResponseDTO createAuthor(AuthorDTO authorDTO) {
        Author authorToSave = authorMapper.toModel(authorDTO);
        Author savedAuthor = authorRepository.save(authorToSave);
        return createMessageResponse(savedAuthor.getId(), "Saved author with id: ");
    }

    @Transactional(readOnly = true)
    public List<AuthorDTO> listAll() {
        List<Author> allPublishers = authorRepository.findAll();
        return allPublishers
                .stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AuthorDTO findById(Long id) throws AuthorNotFoundException {
        Author author = verifyByExists(id);
        return authorMapper.toDTO(author);
    }

    @Transactional
    public MessageResponseDTO updateById(Long id, @Valid AuthorDTO authorDTO) throws AuthorNotFoundException {
        Author authorExists = verifyByExists(id);

        /*
        * Porque não usei Builder() na atualização de Authors?
        * Resposta: porque ele atualizaria todos os campos da entidade Book. Neste caso,
        * a atualização precisa ser somente nos dados relacionados a entidade Author. Usando Builder()
        * na atualização dos campos Author, como o Book estaria nulo or não ser utilizado,
        * o Builder atualizaria os dados do Book eliminando os registros de
        * livros da entidade Book.
        * */
        if(!authorExists.getId().equals(0)) {
            authorExists.setId(authorDTO.getId());
            authorExists.setAuthorName(authorDTO.getAuthorName());
            authorExists.setAuthorMail(authorDTO.getAuthorMail());
            authorExists.setBirthDate(authorDTO.getBirthDate());
            authorExists.setDateDeath(authorDTO.getDateDeath());

            Author updatedAuthor = authorRepository.save(authorExists);

            return createMessageResponse(updatedAuthor.getId(), "Updated author with id: ");
        }

        return createMessageResponse(0L, "Author not found to updated.");
    }

    @Transactional
    public void delete(Long id) throws AuthorNotFoundException {
        verifyByExists(id);
        authorRepository.deleteById(id);
    }

    private Author verifyByExists(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    private static MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}