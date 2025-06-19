package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.GenderDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.exception.GenderNotFoundException;
import io.github.pedrossjr.livraria.services.GenderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class GenderController {

    private final GenderService genderService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createGender (@RequestBody @Valid GenderDTO genderDTO) {
        return genderService.createGender(genderDTO);
    }

    @GetMapping("/list")
    public List<GenderDTO> listAll(){
        return genderService.listAll();
    }

    @GetMapping("/{id}/list")
    public GenderDTO findById(@PathVariable  Long id) throws GenderNotFoundException {
        return genderService.findById(id);
    }

    @PutMapping("/{id}/update")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid GenderDTO genderDTO) throws GenderNotFoundException {
        return genderService.updateById(id, genderDTO);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws GenderNotFoundException {
        genderService.delete(id);
    }

}