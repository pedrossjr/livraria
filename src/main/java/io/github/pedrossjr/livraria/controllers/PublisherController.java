package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.PublisherDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.exception.PublisherNotFoundException;
import io.github.pedrossjr.livraria.services.PublisherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPublisher (@RequestBody @Valid PublisherDTO publisherDTO ) {
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

    @PutMapping("/{id}/update")
    public  MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PublisherDTO publisherDTO) throws PublisherNotFoundException {
        return publisherService.updateById(id, publisherDTO);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PublisherNotFoundException {
        publisherService.delete(id);
    }

}
