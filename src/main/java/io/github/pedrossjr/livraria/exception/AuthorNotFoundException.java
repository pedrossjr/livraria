package io.github.pedrossjr.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(Long id) {
        super("Author not found with id: " + id);
    }
}
