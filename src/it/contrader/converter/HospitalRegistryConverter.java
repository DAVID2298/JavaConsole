package it.contrader.converter;

import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.model.Appointment;
import it.contrader.model.HospitalRegistry;

import java.util.ArrayList;
import java.util.List;

public class HospitalRegistryConverter {

    public HospitalRegistryDTO toDTO(HospitalRegistry hospitalRegistry){
        HospitalRegistryDTO hospitalRegistryDTO= new HospitalRegistryDTO(hospitalRegistry.getId(),
                hospitalRegistry.getName(),
                hospitalRegistry.getAddress(),
                hospitalRegistry.getNation(),
                hospitalRegistry.getProvince(),
                hospitalRegistry.getCity(),
                hospitalRegistry.getDescription(),
                hospitalRegistry.getUser_id());
                return hospitalRegistryDTO;

    }

    public HospitalRegistry toEntity(HospitalRegistryDTO hospitalRegistryDTO){
        HospitalRegistry hospitalRegistry= new HospitalRegistry(hospitalRegistryDTO.getId(),
                hospitalRegistryDTO.getName(),
                hospitalRegistryDTO.getAddress(),
                hospitalRegistryDTO.getNation(),
                hospitalRegistryDTO.getProvince(),
                hospitalRegistryDTO.getCity(),
                hospitalRegistryDTO.getDescription(),
                hospitalRegistryDTO.getUser_id());
        return hospitalRegistry;

    }

    public List<HospitalRegistryDTO> toDTOList(List<HospitalRegistry> hospitalRegistryList) {
        //Crea una lista vuota.
        List<HospitalRegistryDTO> hospitalRegistryDTOList = new ArrayList<HospitalRegistryDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(HospitalRegistry hospitalRegistry : hospitalRegistryList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            hospitalRegistryDTOList.add(toDTO(hospitalRegistry));
        }
        return hospitalRegistryDTOList;
    }

}
