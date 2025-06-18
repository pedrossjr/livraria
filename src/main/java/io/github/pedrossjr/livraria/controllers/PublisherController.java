package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.exception.PublisherNotFoundException;
import io.github.pedrossjr.livraria.services.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPtblisher (@RequestBody @Valid PublisherDTO publisherDTO ) {
        return publisherService.createPublisher(publisherDTO);
    }

    @GetMapping("/list")
    public List<PublisherDTO> listAll(){
        return publisherService.listAll();
    }

    @GetMapping("/{id}/list")
    public PublisherDTO findById(@PathVariable Long id) throws PublisherNotFoundException {
        return  publisherService.findById(id);

    }


}
