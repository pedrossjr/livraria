package io.github.pedrossjr.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.pedrossjr.livraria.entities.Author;
import io.github.pedrossjr.livraria.entities.Gender;
import io.github.pedrossjr.livraria.entities.Publisher;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int agePublish;
    private int numberPages;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate = LocalDateTime.now();

}