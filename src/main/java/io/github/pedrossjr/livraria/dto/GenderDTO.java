package io.github.pedrossjr.livraria.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenderDTO {

    private Long id;
    @NotEmpty(message = "{field.gender.mandatory}")
    private String genderName;

}
