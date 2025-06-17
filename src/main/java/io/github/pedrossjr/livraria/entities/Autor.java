package io.github.pedrossjr.livraria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65)
    @NotEmpty(message = "{campo.nome-autor.obrigatorio}")
    private String nomeAutor;

    @Column(length = 65)
    @NotEmpty(message = "{campo.email-autor.obrigatorio}")
    private String emailAutor;

    @JsonIgnore
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private Set<Livro> livros;

    private LocalDate dataNascimento;

    private LocalDate dataFalecimento;

}