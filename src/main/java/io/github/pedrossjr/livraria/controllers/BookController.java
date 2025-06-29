package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.BookDTO;
import io.github.pedrossjr.livraria.dto.BookListDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.exception.BookBusinessException;
import io.github.pedrossjr.livraria.exception.BookNotFoundException;
import io.github.pedrossjr.livraria.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createBook (@RequestBody @Valid BookDTO bookDTO ) throws BookBusinessException {
        return bookService.createBook(bookDTO);
    }

    @GetMapping("/list")
    public List<BookDTO> listAll(){
        return bookService.listAll();
    }

    @GetMapping("/{id}/list")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @GetMapping("/{id}/genderlist")
    public List<BookListDTO> findByIdGender(@PathVariable Long id) throws BookNotFoundException {
        List<BookListDTO> allBooksForGender = bookService.listByIdGender(id);
        return allBooksForGender;
    }

    @GetMapping("/gender/{genderId}/author/{authorId}/list")
    public List<BookDTO> findByGenderIdAndAuthorId(@PathVariable Long genderId, @PathVariable Long authorId) throws BookNotFoundException {
        List<BookDTO> allBooksForGenderAndAuthor = bookService.findByGenderAndAuthor(genderId, authorId);
        return allBooksForGenderAndAuthor;
    }

    @PutMapping("/{id}/update")
    public  MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) throws BookNotFoundException {
        return bookService.updateById(id, bookDTO);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BookNotFoundException {
        bookService.delete(id);
    }

}