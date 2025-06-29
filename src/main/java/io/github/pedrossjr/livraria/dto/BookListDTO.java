package io.github.pedrossjr.livraria.dto;

import io.github.pedrossjr.livraria.projections.BookGenderProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookListDTO {

    private String isbnNumber;
    private String bookTitle;
    private String bookDescription;
    private String authorName;
    private String genderName;
    private String publisherName;
    private int agePublish;
    private int numberPages;

    public BookListDTO(BookGenderProjection bookGenderProjection){

        isbnNumber = bookGenderProjection.getIsbnNumber();
        bookTitle = bookGenderProjection.getBookTitle();
        bookDescription = bookGenderProjection.getBookDescription();
        authorName = bookGenderProjection.getAuthorName();
        genderName = bookGenderProjection.getGenderName();
        publisherName = bookGenderProjection.getPublisherName();
        agePublish = bookGenderProjection.getAgePublish();
        numberPages = bookGenderProjection.getNumberPages();

    }

}