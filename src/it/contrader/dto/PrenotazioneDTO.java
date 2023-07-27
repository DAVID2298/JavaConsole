package it.contrader.dto;

public class PrenotazioneDTO {
    private int id_prenotazione;
    private String data;
    private String orario;
    private double costo;
    private int id_user;
    private int id_visita;

    public PrenotazioneDTO(int id_prenotazione, String data, String orario, double costo, int id_user, int id_visita) {
        this.id_prenotazione = id_prenotazione;
        this.data = data;
        this.orario = orario;
        this.costo = costo;
        this.id_user = id_user;
        this.id_visita = id_visita;
    }

    public PrenotazioneDTO() {
    }

    public PrenotazioneDTO(String data, String orario, double costo) {
        this.data = data;
        this.orario = orario;
        this.costo = costo;
    }

    public int getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(int id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id_prenotazione=" + id_prenotazione +
                ", data='" + data + '\'' +
                ", orario='" + orario + '\'' +
                ", costo=" + costo +
                ", id_user=" + id_user +
                ", id_visita=" + id_visita +
                '}';
    }
}
