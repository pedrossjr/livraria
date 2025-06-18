package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Publisher;
import io.github.pedrossjr.livraria.exception.PublisherNotFoundException;
import io.github.pedrossjr.livraria.mapper.PublisherMapper;
import io.github.pedrossjr.livraria.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Transactional
    public MessageResponseDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisherToSave = publisherMapper.toModel(publisherDTO);

        Publisher savedPublisher = publisherRepository.save(publisherToSave);

        return MessageResponseDTO
            .builder()
            .message("Created publisher with ID " + savedPublisher.getId())
            .build();
    }

    public List<PublisherDTO> listAll() {
        List<Publisher> allPublisher = publisherRepository.findAll();
        return allPublisher
                .stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PublisherDTO findById(Long id) throws PublisherNotFoundException {
        Publisher publisher = verifyByExists(id);
        return publisherMapper.toDTO(publisher);
    }

    public void delete(Long id) throws PublisherNotFoundException {
        verifyByExists(id);
        publisherRepository.deleteById(id);
    }

    private Publisher verifyByExists(Long id) throws PublisherNotFoundException {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));

    }
}