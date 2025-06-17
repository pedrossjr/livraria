package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.AutorDTO;
import io.github.pedrossjr.livraria.entities.Autor;
import io.github.pedrossjr.livraria.repositories.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private ModelMapper modelMapper;

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AutorDTO salvar(AutorDTO autorDTO){
        Autor autor = new Autor();

        autor.setNomeAutor(autorDTO.getNomeAutor());
        autor.setEmailAutor(autorDTO.getEmailAutor());
        autor.setDataNascimento(autorDTO.getDataNascimento());
        autor.setDataFalecimento(autorDTO.getDataFalecimento());

        Autor autorInserido = autorRepository.save(autor);

        AutorDTO responseDTO = modelMapper.map(autorInserido, AutorDTO.class);

        return responseDTO;

    }
}
