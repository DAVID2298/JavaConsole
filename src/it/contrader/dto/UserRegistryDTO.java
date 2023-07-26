package it.contrader.dto;

import java.util.Date;

public class UserRegistryDTO {

    private long id;

    private String name;

    private String address;

    private String surname;

    private Date birthDate;

    private long userId;

    public UserRegistryDTO(long id, String name, String address, String surname, Date birthDate, long userId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.surname = surname;
        this.birthDate = birthDate;
        this.userId = userId;
    }

    public UserRegistryDTO(String name, String address, String surname, Date birthDate) {
        this.name = name;
        this.address = address;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public UserRegistryDTO() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
