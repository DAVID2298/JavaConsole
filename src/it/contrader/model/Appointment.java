package it.contrader.model;

import java.util.Date;
import java.util.TimeZone;

public class Appointment {

    private long id;

    private String date;

    private String hour;

    private double cost;

    private long user_id;
    private long id_ME;

    public Appointment(long id, String date, String hour, double cost, long user_id, long id_ME) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.cost = cost;
        this.user_id = user_id;
        this.id_ME = id_ME;
    }

    public Appointment(String date, String hour, double cost, long id_ME) {
        this.date = date;
        this.hour = hour;
        this.cost = cost;
        this.id_ME = id_ME;
    }

    public Appointment() {
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

    public long getId_ME() {
        return id_ME;
    }

    public void setMedical_booking_id(long medical_booking_id) {
        this.id_ME = id_ME;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id_prenotazione=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", cost=" + cost +
                ", user_id=" + user_id +
                ", id_ME=" + id_ME +
                '}';
    }
}






















