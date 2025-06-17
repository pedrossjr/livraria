package io.github.pedrossjr.livraria.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate birthDate;
    private LocalDate dateDeath;

}