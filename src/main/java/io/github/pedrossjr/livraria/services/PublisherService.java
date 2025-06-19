package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Publisher;
import io.github.pedrossjr.livraria.exception.PublisherNotFoundException;
import io.github.pedrossjr.livraria.mapper.PublisherMapper;
import io.github.pedrossjr.livraria.repositories.PublisherRepository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Transactional
    public MessageResponseDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisherToSave = publisherMapper.toModel(publisherDTO);
        Publisher savedPublisher = publisherRepository.save(publisherToSave);
        return createMessageResponse(savedPublisher.getId(), "Saved publisher with id: ");
    }

    @Transactional(readOnly = true)
    public List<PublisherDTO> listAll() {
        List<Publisher> allPublishers = publisherRepository.findAll();
        return allPublishers
                .stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PublisherDTO findById(Long id) throws PublisherNotFoundException {
        Publisher publisher = verifyByExists(id);
        return publisherMapper.toDTO(publisher);
    }

    @Transactional
    public MessageResponseDTO updateById(Long id, @Valid PublisherDTO publisherDTO) throws PublisherNotFoundException {
        verifyByExists(id);
        Publisher publisherToUpdate = publisherMapper.toModel(publisherDTO);
        Publisher updatedPublisher = publisherRepository.save(publisherToUpdate);
        return createMessageResponse(updatedPublisher.getId(), "Updated publisher with id: ");
    }

    @Transactional
    public void delete(Long id) throws PublisherNotFoundException {
        verifyByExists(id);
        publisherRepository.deleteById(id);
    }

    private Publisher verifyByExists(Long id) throws PublisherNotFoundException {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    private static MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}