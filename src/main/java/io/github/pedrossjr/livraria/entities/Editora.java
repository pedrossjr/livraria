package io.github.pedrossjr.livraria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_editoras")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    @NotEmpty(message = "{campo.nome-editora.obrigatorio}")
    private String nomeEditora;

    @Column(length = 45)
    @NotEmpty(message = "{campo.email-editora.obrigatorio}")
    private String emailEditora;

    @JsonIgnore
    @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
    private Set<Livro> livros;

}
