package it.contrader.service;

import it.contrader.converter.UserRegistryConverter;
import it.contrader.dao.UserRegistryDAO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;

import java.util.List;

public class UserRegistryService {
    private UserRegistryDAO userRegistryDAO;
    private UserRegistryConverter userRegistryConverter;

    public UserRegistryService(){
        this.userRegistryConverter= new UserRegistryConverter();
        this.userRegistryDAO= new UserRegistryDAO();

    }
    public List<UserRegistryDTO> getAll() {
        // Ottiene una lista di entità e le restituisce convertendole in DTO
        return userRegistryConverter.toDTOList(userRegistryDAO.getAll());
    }


    public UserRegistryDTO read(int Id) {
        // Ottiene un'entità e la restituisce convertendola in DTO
        return userRegistryConverter.toDTO(userRegistryDAO.read(Id));
    }

    public int readId(int userId){
        return userRegistryDAO.readId(userId);
    }


    public boolean insert(UserRegistryDTO dto) {
        // Converte un DTO in entità e lo passa al DAO per l'inserimento
        return userRegistryDAO.insert(userRegistryConverter.toEntity(dto));

    }



    public boolean update(UserRegistryDTO dto) {
        // Converte un userDTO in entità e lo passa allo userDAO per la modifica
        return userRegistryDAO.update(userRegistryConverter.toEntity(dto));
    }

}
