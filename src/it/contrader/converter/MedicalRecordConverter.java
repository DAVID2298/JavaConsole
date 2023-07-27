package it.contrader.converter;

import it.contrader.dto.MedicalRecordDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.MedicalRecord;
import it.contrader.model.User;

public class MedicalRecordConverter {

    /**
     * Crea un oggetto di tipo MedicalRecordDTO e lo riempie con i campi del parametro user di tipo MedicalRecord.
     * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
     */

    public MedicalRecordDTO toDTO(MedicalRecord medicalRecord) {
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(medicalRecord.getId(),
                medicalRecord.getDate(),
                medicalRecord.getHours(),
                medicalRecord.getMedicalCheck(),
                medicalRecord.getDescription(),
                medicalRecord.getId_anagraphic());
        return medicalRecordDTO;
    }

    public MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO){
        MedicalRecord medicalRecord = new MedicalRecord(medicalRecordDTO.getId(),
                medicalRecordDTO.getDate(),
                medicalRecordDTO.getHours(),
                medicalRecordDTO.getMedicalCheck(),
                medicalRecordDTO.getDescription(),
                medicalRecordDTO.getId_anagraphic());
        return medicalRecord;
    }
}
