package it.contrader.converter;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;

public class UserRegistryConverter {

    public UserRegistryDTO toDTO(UserRegistry userRegistry){

        UserRegistryDTO userRegistryDTO = new UserRegistryDTO(userRegistry.getId(),
                userRegistry.getAddress(),
                userRegistry.getName(),
                userRegistry.getSurname(),
                userRegistry.getBirthDate(),
                userRegistry.getUserId());
        return userRegistryDTO;
    }

    public UserRegistry toEntity(UserRegistryDTO userRegistryDTO){

        UserRegistry userRegistry = new UserRegistry(userRegistryDTO.getId(),
                userRegistryDTO.getAddress(),
                userRegistryDTO.getName(),
                userRegistryDTO.getSurname(),
                userRegistryDTO.getBirthDate(),
                userRegistryDTO.getUserId());
        return userRegistry;
    }
}
