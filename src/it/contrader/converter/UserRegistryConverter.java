package it.contrader.converter;

import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.UserRegistry;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserRegistryDTO> toDTOList(List<UserRegistry> userRegistryList) {
        //Crea una lista vuota.
        List<UserRegistryDTO> userRegistryDTOList = new ArrayList<UserRegistryDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(UserRegistry userRegistry : userRegistryList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            userRegistryDTOList.add(toDTO(userRegistry));
        }
        return userRegistryDTOList;
    }
}
