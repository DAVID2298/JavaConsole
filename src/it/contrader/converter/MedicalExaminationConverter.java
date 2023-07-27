package it.contrader.converter;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.model.MedicalExamination;

public class MedicalExaminationConverter {

    public MedicalExaminationDTO toDTO(MedicalExamination medicalExamination){
        MedicalExaminationDTO medicalExaminationDTO=new MedicalExaminationDTO(
                medicalExamination.getId(),
                medicalExamination.getName(),
                medicalExamination.getTypology(),
                medicalExamination.getCost(),
                medicalExamination.getCode(),
                medicalExamination.getHours(),
                medicalExamination.getImg());
        return medicalExaminationDTO;
    }

    public MedicalExamination toEntity(MedicalExaminationDTO medicalExaminationDTO){
        MedicalExamination medicalExamination=new MedicalExamination(
                medicalExaminationDTO.getId(),
                medicalExaminationDTO.getName(),
                medicalExaminationDTO.getTypology(),
                medicalExaminationDTO.getCost(),
                medicalExaminationDTO.getCode(),
                medicalExaminationDTO.getHours(),
                medicalExaminationDTO.getImg());
        return medicalExamination;
    }
}
