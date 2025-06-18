package io.github.pedrossjr.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PublisherNotFoundException extends Exception {
    public PublisherNotFoundException(Long id) {
        super("Publisher not found with ID " + id);
    }
}
