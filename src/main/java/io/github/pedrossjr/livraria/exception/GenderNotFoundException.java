package io.github.pedrossjr.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenderNotFoundException extends Exception {
    public GenderNotFoundException(Long id) {
        super("Gender not found with id: " + id);
    }
}
