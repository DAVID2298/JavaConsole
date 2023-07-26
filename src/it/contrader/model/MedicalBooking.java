package it.contrader.model;

import java.util.Date;
import java.util.TimeZone;

public class MedicalBooking {

    private long id;

    private Date date;

    private TimeZone hour;

    private double cost;


    public MedicalBooking(long id, Date date, TimeZone hour, double cost) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.cost = cost;
    }

    public MedicalBooking(Date date, TimeZone hour, double cost) {
        this.date = date;
        this.hour = hour;
        this.cost = cost;
    }

    public MedicalBooking(){

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

    public TimeZone getHour() {
        return hour;
    }

    public void setHour(TimeZone hour) {
        this.hour = hour;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MedicalBooking{" +
                "id=" + id +
                ", date=" + date +
                ", hour=" + hour +
                ", cost=" + cost +
                '}';
    }
}
