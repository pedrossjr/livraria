package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Book;
import io.github.pedrossjr.livraria.exception.BookNotFoundException;
import io.github.pedrossjr.livraria.exception.BookBusinessException;
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
    public MessageResponseDTO createBook(BookDTO bookDTO) throws BookBusinessException {
        if(verifyByIsbnExists(bookDTO.getIsbnNumber())){
            throw new BookBusinessException("There is already a book with the ISBN entered.");
        }

        Book bookToSave = bookMapper.toModel(bookDTO);
        Book savadBook = bookRepository.save(bookToSave);

        return createMessageResponse(savadBook.getId(), "Saved book with id: ");
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
        return createMessageResponse(updateBook.getId(), "Updated book with id: " );
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

    private boolean verifyByIsbnExists(String isbn) {
        return bookRepository.existsByIsbnNumber(isbn);
    }

    private static MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}