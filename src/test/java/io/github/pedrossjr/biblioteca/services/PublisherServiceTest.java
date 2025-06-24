package io.github.pedrossjr.biblioteca.services;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Publisher;
import io.github.pedrossjr.livraria.mapper.PublisherMapper;
import io.github.pedrossjr.livraria.repositories.PublisherRepository;
import io.github.pedrossjr.livraria.services.PublisherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Os imports abaixo se faz manualmente
import static io.github.pedrossjr.biblioteca.utils.PublisherUtils.createFakeDTO;
import static io.github.pedrossjr.biblioteca.utils.PublisherUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;

    @Mock
    private PublisherMapper publisherMapper;

    @InjectMocks
    private PublisherService publisherService;

    @Test
    void testGivenPublisherDTOThenReturnSuccessSavedMessage() {
        PublisherDTO publisherDTO = createFakeDTO();
        Publisher expectedSavedPublisher = createFakeEntity();

        when(publisherMapper.toModel(publisherDTO)).thenReturn(expectedSavedPublisher);
        when(publisherRepository.save(any(Publisher.class))).thenReturn(expectedSavedPublisher);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPublisher.getId());
        MessageResponseDTO successMessage = publisherService.createPublisher(publisherDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Saved publisher with id: " + savedPersonId)
                .build();
    }




}
