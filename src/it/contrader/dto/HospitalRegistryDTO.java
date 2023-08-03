package it.contrader.dto;

public class HospitalRegistryDTO {

    private long id;

    private String name;

    private String address;

    private String nation;

    private String province;

    private String city;

    private String description;

    private long user_id;

    public HospitalRegistryDTO(long id, String name, String address, String nation, String province, String city, String description, long user_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nation = nation;
        this.province = province;
        this.city = city;
        this.description = description;
        this.user_id = user_id;

    }

    public HospitalRegistryDTO(String name, String address, String nation, String province, String city, String description,long user_id) {
        this.name = name;
        this.address = address;
        this.nation = nation;
        this.province = province;
        this.city = city;
        this.description = description;
        this.user_id=user_id;
    }

    public HospitalRegistryDTO() {

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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "HospitalRegistryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
