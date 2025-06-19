package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.AuthorDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Book;
import io.github.pedrossjr.livraria.exception.AuthorNotFoundException;
import io.github.pedrossjr.livraria.services.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAuthor (@RequestBody @Valid AuthorDTO authorDTO ) {
        return authorService.createAuthor(authorDTO);
    }

    @GetMapping("/list")
    public List<AuthorDTO> listAll(){
        return authorService.listAll();
    }

    @GetMapping("/{id}/list")
    public AuthorDTO findById(@PathVariable Long id) throws AuthorNotFoundException {
        return  authorService.findById(id);
    }

    @PutMapping("/{id}/update")
    public  MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid AuthorDTO authorDTO) throws AuthorNotFoundException {
        return authorService.updateById(id, authorDTO);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AuthorNotFoundException {
        authorService.delete(id);
    }

}