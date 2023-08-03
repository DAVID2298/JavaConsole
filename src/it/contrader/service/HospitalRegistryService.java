package it.contrader.service;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.converter.MedicalExaminationConverter;
import it.contrader.converter.UserRegistryConverter;
import it.contrader.dao.HospitalRegistryDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.UserSingleton;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.MedicalExamination;
import it.contrader.model.User;
import it.contrader.model.UserRegistry;

import java.util.ArrayList;
import java.util.List;

public class HospitalRegistryService {

    private HospitalRegistryDAO hospitalRegistryDAO;
    private UserDAO userDAO;
    private HospitalRegistryConverter hospitalRegistryConverter;
    private UserRegistryConverter userRegistryConverter;
    private MedicalExaminationConverter medicalExaminationConverter;
    private UserSingleton userSingleton;

    public HospitalRegistryService() {
        this.hospitalRegistryDAO=new HospitalRegistryDAO();
        this.hospitalRegistryConverter=new HospitalRegistryConverter();
        this.userRegistryConverter=new UserRegistryConverter();
        this.userDAO=new UserDAO();
        this.medicalExaminationConverter=new MedicalExaminationConverter();
        this.userSingleton= UserSingleton.getInstance();
    }

    public List<HospitalRegistryDTO> getAll() {

        List<HospitalRegistry> userList=hospitalRegistryDAO.getAll();
        // Ottiene una lista di entit� e le restituisce convertendole in DTO
        return hospitalRegistryConverter.toDTOList(hospitalRegistryDAO.getAll());
    }

    public boolean delete(int id) {
        // Questo mtodo chiama direttamente il DAO
        return hospitalRegistryDAO.delete(id);
    }

    public void insert(HospitalRegistryDTO dto){
        hospitalRegistryDAO.insert(hospitalRegistryConverter.toEntity(dto));

    }

    public HospitalRegistryDTO read(int id){
        return  hospitalRegistryConverter.toDTO(hospitalRegistryDAO.read(id));
    }

    public int readId(int userId){
        return hospitalRegistryDAO.readId(userId);
    }

    public boolean update(HospitalRegistryDTO dto) {
        // Converte un userDTO in entità e lo passa allo userDAO per la modifica
        return hospitalRegistryDAO.update(hospitalRegistryConverter.toEntity(dto));
    }
}
