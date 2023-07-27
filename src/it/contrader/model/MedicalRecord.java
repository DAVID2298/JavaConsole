package it.contrader.model;

import java.util.Date;
import java.util.TimeZone;

public class MedicalRecord {

    private long id;

    private String date;

    private String hours;

    private String medicalCheck;

    private String description;

    private long id_anagraphic;

    public MedicalRecord(long id, String date, String hours, String medicalCheck, String description,long id_anagraphic) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.medicalCheck = medicalCheck;
        this.description = description;
        this.id_anagraphic=id_anagraphic;
    }

    public MedicalRecord(String date, String hours, String medicalCheck, String description) {
        this.date = date;
        this.hours = hours;
        this.medicalCheck = medicalCheck;
        this.description = description;
    }

    public MedicalRecord(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMedicalCheck() {
        return medicalCheck;
    }

    public void setMedicalCheck(String medicalCheck) {
        this.medicalCheck = medicalCheck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId_anagraphic() {
        return id_anagraphic;
    }


    public void setId_anagraphic(long id_anagraphic) {
        this.id_anagraphic = id_anagraphic;

    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", date=" + date +
                ", hours=" + hours +
                ", medicalCheck='" + medicalCheck + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
