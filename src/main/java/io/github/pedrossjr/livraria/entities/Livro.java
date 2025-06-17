package io.github.pedrossjr.livraria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "{campo.isbn-livro.obrigatorio}")
    private String isbn;

    @Column(length = 45)
    @NotEmpty(message = "{campo.titulo-livro.obrigatorio}")
    private String tituloLivro;

    @Column(columnDefinition = "TEXT")
    private String descricaoLivro;

    private int numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

}
