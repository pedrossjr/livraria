package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.EditoraDTO;
import io.github.pedrossjr.livraria.entities.Editora;
import io.github.pedrossjr.livraria.repositories.EditoraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public EditoraDTO salvar(EditoraDTO editoraDTO) {
        Editora editora = new Editora();

        editora.setNomeEditora(editoraDTO.getNomeEditora());
        editora.setEmailEditora(editoraDTO.getEmailEditora());

        Editora editoraInserida = editoraRepository.save(editora);

        EditoraDTO responseDTO = modelMapper.map(editoraInserida, EditoraDTO.class);

        return responseDTO;

    }

    @Transactional(readOnly = true)
    public List<EditoraDTO> listarTodos() {

        List<Editora> listaEditora = editoraRepository.findAll();

        List<EditoraDTO> responseDTO = Collections.singletonMap(modelMapper.map(listaEditora, EditoraDTO.class));

        System.out.println(responseDTO);

        return responseDTO;


    }
}
