package it.contrader.dto;

import it.contrader.model.MedicalExamination;

import java.util.Date;
import java.util.TimeZone;

public class AppointmentDTO {

    private long id;

    private String date;

    private String hour;

    private double cost;

    private long user_id;
    private long medical_booking_id;

    public AppointmentDTO(long id, String date, String hour, double cost, long user_id, long medical_booking_id) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.cost = cost;
        this.user_id = user_id;
        this.medical_booking_id = medical_booking_id;
    }

    public AppointmentDTO(String date, String hour, double cost, long medical_booking_id) {
        this.date = date;
        this.hour = hour;
        this.cost = cost;
        this.medical_booking_id = medical_booking_id;
    }

    public AppointmentDTO() {
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getMedical_booking_id() {
        return medical_booking_id;
    }

    public void setMedical_booking_id(long medical_booking_id) {
        this.medical_booking_id = medical_booking_id;
    }
}
