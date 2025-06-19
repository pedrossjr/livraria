package io.github.pedrossjr.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {

    private Long id;
    @NotEmpty(message = "{field.author-name.mandatory}")
    private String authorName;
    @NotEmpty(message = "{field.author-mail.mandatory}")
    private String authorMail;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateDeath;
    private List<BookDTO> books;

}