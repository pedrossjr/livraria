package io.github.pedrossjr.livraria.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private Long id;
    @NotEmpty(message = "{field.book-isbn.mandatory}")
    private String isbn;
    @NotEmpty(message = "{field.book-title.mandatory}")
    private String bookTitle;
    private String bookDescription;
    private int numberPages;
    private LocalDateTime registrationDate = LocalDateTime.now();

}