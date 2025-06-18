package io.github.pedrossjr.livraria.services;

import io.github.pedrossjr.livraria.dto.GenderDTO;
import io.github.pedrossjr.livraria.dto.response.MessageResponseDTO;
import io.github.pedrossjr.livraria.entities.Gender;
import io.github.pedrossjr.livraria.exception.GenderNotFoundException;
import io.github.pedrossjr.livraria.mapper.GenderMapper;
import io.github.pedrossjr.livraria.repositories.GenderRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class GenderService {

    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    @Transactional
    public MessageResponseDTO createGender(GenderDTO genderDTO) {
        Gender genderToSave = genderMapper.toModel(genderDTO);
        Gender savedGender = genderRepository.save(genderToSave);
        return  createMessageResponse(savedGender.getId(), "Savad gander with id: ");
    }

    @Transactional(readOnly = true)
    public GenderDTO findById(Long id) throws GenderNotFoundException {
        Gender gender = verifyByExists(id);
        return genderMapper.toDTO(gender);
    }

    @Transactional
    public MessageResponseDTO updateById(Long id, @Valid GenderDTO genderDTO) throws GenderNotFoundException {
        verifyByExists(id);
        Gender genderToUpdate = genderMapper.toModel(genderDTO);
        Gender updatedGender = genderRepository.save(genderToUpdate);
        return createMessageResponse(updatedGender.getId(), "Updated gender with id: ");
    }

    @Transactional
    public void delete(Long id) throws GenderNotFoundException {
        verifyByExists(id);
        genderRepository.deleteById(id);
    }

    private Gender verifyByExists(Long id) throws GenderNotFoundException {
        return genderRepository.findById(id)
                .orElseThrow(() -> new GenderNotFoundException(id));
    }

    private static MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}