package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.dto.GenderDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Book;
import io.github.pedrossjr.livraria.entities.Gender;
import io.github.pedrossjr.livraria.exception.BookNotFoundException;
import io.github.pedrossjr.livraria.mapper.BookMapper;
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
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Transactional
    public MessageResponseDTO createBook(BookDTO bookDTO) throws BookNotFoundException {

        Book bookToSave = bookMapper.toModel(bookDTO);
        verifyByIsbnExists(bookDTO.getIsbn());
        Book savadBook = bookRepository.save(bookToSave);
        return createMessageResponse(savadBook.getId(), "Savad book with id: ");
    }

    @Transactional(readOnly = true)
    public List<BookDTO> listAll() {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = verifyByExists(id);
        return bookMapper.toDTO(book);
    }

    @Transactional
    public MessageResponseDTO updateById(Long id, @Valid BookDTO bookDTO) throws BookNotFoundException {
        verifyByExists(id);
        Book bookToUpdate = bookMapper.toModel(bookDTO);
        Book updateBook = bookRepository.save(bookToUpdate);
        return createMessageResponse(updateBook.getId(), "Updated book with id:" );
    }

    @Transactional
    public void delete(Long id) throws BookNotFoundException {
        verifyByExists(id);
        bookRepository.deleteById(id);
    }

    private Book verifyByExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private Book verifyByIsbnExists(String isbn) throws BookNotFoundException {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    private static MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}