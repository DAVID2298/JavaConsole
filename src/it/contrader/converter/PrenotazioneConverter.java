package it.contrader.converter;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Prenotazione;
import it.contrader.model.User;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioneConverter {
    public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO(prenotazione.getId_prenotazione(),
                prenotazione.getData(), prenotazione.getOrario(),
                prenotazione.getCosto(), prenotazione.getId_user(),
                prenotazione.getId_visita());
        return prenotazioneDTO;
    }

    public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = new Prenotazione(prenotazioneDTO.getId_prenotazione(),
                prenotazioneDTO.getData(), prenotazioneDTO.getOrario(),
                prenotazioneDTO.getCosto(), prenotazioneDTO.getId_user(), prenotazioneDTO.getId_visita());
        return prenotazione;

    }



        public List<PrenotazioneDTO> toDTOList(List<Prenotazione> prenotazioneList) {
            //Crea una lista vuota.
            List<PrenotazioneDTO> prenotazioneDTOList = new ArrayList<PrenotazioneDTO>();

            //Cicla tutti gli elementi della lista e li converte uno a uno
            for(Prenotazione prenotazione : prenotazioneList) {
                //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
                //e lo aggiunge adda lista di DTO
                prenotazioneDTOList.add(toDTO(prenotazione));
            }
            return prenotazioneDTOList;
        }
}