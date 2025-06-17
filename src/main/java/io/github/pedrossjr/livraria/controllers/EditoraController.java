package io.github.pedrossjr.livraria.controllers;

import io.github.pedrossjr.livraria.dto.EditoraDTO;
import io.github.pedrossjr.livraria.services.EditoraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

//    @PostMapping("/adicionar")
//    @ResponseStatus(HttpStatus.CREATED)
//    public EditoraDTO inserir(@RequestBody @Valid EditoraDTO editoraDTO) {
//        return editoraService.salvar(editoraDTO);
//    }

//    @GetMapping("/listar")
//    public ResponseEntity<List<EditoraDTO>> listar() {
//        return ResponseEntity.ok(editoraService.listarTodos());
//    }
}
