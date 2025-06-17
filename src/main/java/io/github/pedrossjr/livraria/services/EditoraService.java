package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.EditoraDTO;
import io.github.pedrossjr.livraria.entities.Editora;
import io.github.pedrossjr.livraria.mapper.EditoraMapper;
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

    private final EditoraMapper editoraMapper = EditoraMapper.INSTANCE;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public EditoraDTO salvar(EditoraDTO editoraDTO) {

        Editora editoraToSave = editoraMapper.toModel(editoraDTO);

        Editora editoraSave = editoraRepository.save(editoraToSave);

        // TODO - Continuar daqui, verificando o MessageResponseDTO

        //return editoraSave;

//        Editora editora = Editora.builder()
//                .nomeEditora(editoraDTO.getNomeEditora())
//                .emailEditora(editoraDTO.getEmailEditora())
//                .build();




    }

//    @Transactional(readOnly = true)
//    public List<EditoraDTO> listarTodos() {
//
//        List<Editora> listaEditora = editoraRepository.findAll();
//
//        List<EditoraDTO> responseDTO = Collections.singletonMap(modelMapper.map(listaEditora, EditoraDTO.class));
//
//        System.out.println(responseDTO);
//
//        return responseDTO;
//
//
//    }
}
