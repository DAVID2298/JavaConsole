package it.contrader.model;

import java.util.Date;
import java.util.TimeZone;

public class MedicalRecord {

    private long id;

    private Date date;

    private TimeZone hours;

    private String medicalCheck;

    private String description;

    private long

    public MedicalRecord(long id, Date date, TimeZone hours, String medicalCheck, String description) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.medicalCheck = medicalCheck;
        this.description = description;
    }

    public MedicalRecord(Date date, TimeZone hours, String medicalCheck, String description) {
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
