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

    public List<UserRegistryDTO> getAll() {

        List<User> userList=userDAO.getAll();
        for(User user: userList){
            if(user.getUsertype()!="ADMIN"){
                 return new ArrayList<>();
            }
        }

        // Ottiene una lista di entit� e le restituisce convertendole in DTO
        return userRegistryConverter.toDTOList(hospitalRegistryDAO.getAll());
    }

    public boolean delete(int id) {
        // Questo mtodo chiama direttamente il DAO
        return hospitalRegistryDAO.delete(id);
    }

    public void insert(MedicalExaminationDTO dto){
//        userDAO.read(UserSingleton.getInstance().getId());
        hospitalRegistryDAO.insert(medicalExaminationConverter.toEntity(dto));

    }
}
