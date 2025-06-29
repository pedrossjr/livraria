package io.github.pedrossjr.livraria.repositories;

import io.github.pedrossjr.livraria.entities.Book;
import io.github.pedrossjr.livraria.projections.BookGenderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Exemplo utilizando a consulta padrão com a entidade mapeada.
    @Query("SELECT COUNT(b) > 0 FROM Book b WHERE b.isbnNumber = :isbnNumber")
    boolean existsByIsbnNumber(String isbnNumber);

    // Exemplo utilizando a query nativa do banco de dados utilizando Projections.
    @Query(value = "select b.isbn_number, b.book_title, b.book_description, a.author_name, g.gender_name, p.publisher_name, b.age_publish, b.number_pages\n" +
            "from tbl_books b\n" +
            "inner join tbl_publishers p on p.id = b.publisher_id\n" +
            "inner join tbl_genders g on g.id = b.gender_id\n" +
            "inner join tbl_authors a on a.id = b.author_id\n" +
            "where b.gender_id = :id", nativeQuery = true)
    List<BookGenderProjection> reportBookWithGender (Long id);

    /*
    * Exemplo utilizando a própria linguagem do JPA Query Methods, que permite a construção de diversas consultas de
    * forma declarativa e com código limpo, conforme os exemplos apresentados na documentação oficial.
    *
    * Documentação: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    * */
    List<Book> findByGenderIdAndAuthorId(Long genderId, Long authorId);

}