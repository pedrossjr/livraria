package io.github.pedrossjr.livraria.projections;

/*****************************************************************************************
* A utilização da interface BookGenderProjection se faz necessário ao utilizar
* uma consulta personalizada ao banco de dados pelo Repository. Nela, informamos os campos
* que serão exibidos no resultado do JSON apresentado.
******************************************************************************************/

public interface BookGenderProjection {

    String getIsbnNumber();
    String getBookTitle();
    String getBookDescription();
    String getAuthorName();
    String getGenderName();
    String getPublisherName();
    int getAgePublish();
    int getNumberPages();

}
