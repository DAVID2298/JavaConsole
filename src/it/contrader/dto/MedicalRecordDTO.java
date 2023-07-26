package it.contrader.dto;

import java.util.Date;
import java.util.TimeZone;

public class MedicalRecordDTO {

    private long id;

    private Date date;

    private TimeZone hours;

    private String medicalCheck;

    private String description;

    public MedicalRecordDTO(Date date, TimeZone hours, String medicalCheck, String description) {
        this.date = date;
        this.hours = hours;
        this.medicalCheck = medicalCheck;
        this.description = description;
    }

    public MedicalRecordDTO(long id, Date date, TimeZone hours, String medicalCheck, String description) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.medicalCheck = medicalCheck;
        this.description = description;
    }

    public MedicalRecordDTO(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TimeZone getHours() {
        return hours;
    }

    public void setHours(TimeZone hours) {
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
}
