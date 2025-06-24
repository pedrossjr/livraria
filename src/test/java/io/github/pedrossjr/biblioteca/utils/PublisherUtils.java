package io.github.pedrossjr.biblioteca.utils;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.entities.Publisher;

public class PublisherUtils {

    private static final String PUBLISHER_NAME = "Alta Books";
    private static final String PUBLISHER_MAIL = "altabooks@example.com";
    private static final Long PUBLISHER_ID = 1L;

    public static PublisherDTO createFakeDTO() {
        return PublisherDTO.builder()
                .publisherName(PUBLISHER_NAME)
                .publisherMail(PUBLISHER_MAIL)
                .build();
    }

    public static Publisher createFakeEntity() {
        return Publisher.builder()
                .id(PUBLISHER_ID)
                .publisherName(PUBLISHER_NAME)
                .publisherMail(PUBLISHER_MAIL)
                .build();

    }
}