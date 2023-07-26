package it.contrader.converter;

import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.model.HospitalRegistry;

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

}
