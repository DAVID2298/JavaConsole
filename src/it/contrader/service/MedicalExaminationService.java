package it.contrader.service;

import it.contrader.converter.MedicalExaminationConverter;
import it.contrader.converter.MedicalRecordConverter;
import it.contrader.dao.MedicalExaminationDAO;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.MedicalRecordDTO;

import java.util.List;

public class MedicalExaminationService {



    private MedicalExaminationDAO medicalRecordDAO;
    private MedicalExaminationDAO medicalExaminationDAO;
    private MedicalExaminationConverter medicalExaminationConverter;

    //Istanzio DAO  e Converter specifici.
    public MedicalExaminationService(){
        this.medicalExaminationDAO = new MedicalExaminationDAO();
        this.medicalExaminationConverter = new MedicalExaminationConverter();
    }


    public List<MedicalExaminationDTO> getAll() {
        // Ottiene una lista di entit� e le restituisce convertendole in DTO
        return medicalExaminationConverter.toDTOList(medicalExaminationDAO.getAll());
    }


    public MedicalExaminationDTO read(long id) {
        // Ottiene un'entit� e la restituisce convertendola in DTO
        return medicalExaminationConverter.toDTO(medicalExaminationDAO.read(id));
    }


    public boolean insert(MedicalExaminationDTO dto) {
        // Converte un DTO in entit� e lo passa al DAO per l'inserimento
        return medicalExaminationDAO.insert(medicalExaminationConverter.toEntity(dto));
    }


    public boolean update(MedicalExaminationDTO dto) {
        // Converte un userDTO in entit� e lo passa allo userDAO per la modifica
        return medicalExaminationDAO.update(medicalExaminationConverter.toEntity(dto));
    }

    public int readId(int userId){
        return medicalExaminationDAO.readId(userId);
    }

    public boolean delete(long id) {
        // Questo mtodo chiama direttamente il DAO
        return medicalExaminationDAO.delete(id);
    }

    public int statistic(String type){
        return medicalExaminationDAO.statistic(type);
    }

    public MedicalExaminationDTO search(int id){
        return medicalExaminationConverter.toDTO(medicalExaminationDAO.search(id));
    }


}