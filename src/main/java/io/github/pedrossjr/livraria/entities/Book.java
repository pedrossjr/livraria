package io.github.pedrossjr.livraria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String isbnNumber;

    @Column(length = 45)
    private String bookTitle;

    @Column(columnDefinition = "TEXT")
    private String bookDescription;

    private int agePublish;

    private int numberPages;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private LocalDateTime registrationDate = LocalDateTime.now();

}
