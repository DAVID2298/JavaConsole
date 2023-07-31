package it.contrader.dto;

import java.util.Date;

public class UserRegistryDTO {

    private long id;

    private String name;

    private String address;

    private String surname;

    private String birthDate;

    private long user_id;

    public UserRegistryDTO(long id, String name, String address, String surname, String birthDate, long user_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user_id = user_id;
    }

    public UserRegistryDTO(String name, String address, String surname, String birthDate,long user_id) {
        this.name = name;
        this.address = address;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user_id=user_id;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserRegistryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
