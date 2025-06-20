package io.github.pedrossjr.livraria.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDTO {

    private Long id;
    @NotEmpty(message = "{field.publisher-name.mandatory}")
    private String publisherName;
    @NotEmpty(message = "{field.publisher-mail.mandatory}")
    private String publisherMail;

}
