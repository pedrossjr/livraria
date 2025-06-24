package io.github.pedrossjr.livraria.exception;

public class BookBusinessException extends RuntimeException {
    public BookBusinessException(String isbnNumber) {
        super("There is already a book with the ISBN " + isbnNumber + " entered.");
    }
}
