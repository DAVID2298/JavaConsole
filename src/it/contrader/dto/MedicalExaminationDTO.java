package it.contrader.dto;

import java.util.TimeZone;

public class MedicalExaminationDTO {

    private long id;

    private String name;

    private String typology;

    private double cost;

    private long code;

    private String hours;

    private String img;

    private long userId;

    public MedicalExaminationDTO(long id, String name, String typology, double cost, long code, String hours, String img) {
        this.id = id;
        this.name = name;
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.hours = hours;
        this.img = img;
    }

    public MedicalExaminationDTO(long id, String name, String typology, double cost, long code, String hours, String img,long userId) {
        this.id = id;
        this.name = name;
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.hours = hours;
        this.img = img;
        this.userId=userId;
    }

    public MedicalExaminationDTO(String name, String typology, double cost, long code, String hours, String img) {
        this.name = name;
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.hours = hours;
        this.img = img;
    }

    public MedicalExaminationDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "MedicalExaminationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typology='" + typology + '\'' +
                ", cost=" + cost +
                ", code=" + code +
                ", hours='" + hours + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
