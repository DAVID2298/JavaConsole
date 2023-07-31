//package it.contrader.service;
//
//import it.contrader.converter.MedicalRecordConverter;
//import it.contrader.dao.MedicalRecordDAO;
//import it.contrader.dto.MedicalRecordDTO;
//import java.util.List;
//
//public class MedicalRecordService {
//    private MedicalRecordDAO medicalRecordDAO;
//    private MedicalRecordConverter medicalRecordConverter;
//
//    //Istanzio DAO  e Converter specifici.
//    public MedicalRecordService(){
//        this.medicalRecordDAO = new MedicalRecordDAO();
//        this.medicalRecordConverter = new MedicalRecordConverter();
//    }
//
//
//    public List<MedicalRecordDTO> getAll() {
//        // Ottiene una lista di entit� e le restituisce convertendole in DTO
//        return medicalRecordConverter.toDTOList(medicalRecordDAO.getAll());
//    }
//
//
//    public MedicalRecordDTO read(long id) {
//        // Ottiene un'entit� e la restituisce convertendola in DTO
//        return medicalRecordConverter.toDTO(medicalRecordDAO.read(id));
//    }
//
//
//    public boolean insert(MedicalRecordDTO dto) {
//        // Converte un DTO in entit� e lo passa al DAO per l'inserimento
//        return medicalRecordDAO.insert(medicalRecordConverter.toEntity(dto));
//    }
//
//
//    public boolean update(MedicalRecordDTO dto) {
//        // Converte un userDTO in entit� e lo passa allo userDAO per la modifica
//        return medicalRecordDAO.update(medicalRecordConverter.toEntity(dto));
//    }
//
//
//    public boolean delete(int id) {
//        // Questo mtodo chiama direttamente il DAO
//        return medicalRecordDAO.delete(id);
//    }
//
//}