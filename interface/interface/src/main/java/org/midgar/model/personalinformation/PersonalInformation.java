package org.midgar.model.personalinformation;


import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PersonalInformation implements IDto, Serializable {

    private static final long serialVersionUID = 3440684777140763445L;

    private BigDecimal user_id;
    private BigDecimal shirt_size;
    private BigDecimal pants_size;
    private BigDecimal shoes_size;
    private String gender, city, department;
    private String birthdate;

    public PersonalInformation() {
    }

    public PersonalInformation(BigDecimal user_id,
                               BigDecimal shirt_size,
                               BigDecimal pants_size,
                               BigDecimal shoes_size,
                               String gender, String city, String department,
                               String birthdate) {
        this.user_id = user_id;
        this.shirt_size = shirt_size;
        this.pants_size = pants_size;
        this.shoes_size = shoes_size;
        this.gender = gender;
        this.city = city;
        this.department = department;
        this.birthdate = birthdate;
    }

    public BigDecimal getUser_id() {
        return user_id;
    }

    public void setUser_id(BigDecimal user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getShirt_size() {
        return shirt_size;
    }

    public void setShirt_size(BigDecimal shirt_size) {
        this.shirt_size = shirt_size;
    }

    public BigDecimal getPants_size() {
        return pants_size;
    }

    public void setPants_size(BigDecimal pants_size) {
        this.pants_size = pants_size;
    }

    public BigDecimal getShoes_size() {
        return shoes_size;
    }

    public void setShoes_size(BigDecimal shoes_size) {
        this.shoes_size = shoes_size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "user_id=" + user_id +
                ", shirt_size=" + shirt_size +
                ", pants_size=" + pants_size +
                ", shoes_size=" + shoes_size +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public String insert() {
        return "INSERT INTO PERSONAL_INFORMATION (user_id, gender, birthdate, shirt_size, pants_size, shoes_size, city, department) VALUES("
                + getUser_id() + ",'"
                + getGender().trim() + "','"
                + getBirthdate().trim() + "',"
                + getShirt_size() + ","
                + getPants_size() + ","
                + getShoes_size() + ",'"
                + getCity().trim() + "','"
                + getDepartment().trim() + "')";
    }

    @Override
    public String update() {
        return "UPDATE PERSONAL_INFORMATION SET gender= '" + getGender().trim() + "', shirt_size ='"
                + getShirt_size() + "', pants_size= '"
                + getPants_size() + "', shoes_size= '"
                + getShoes_size() + "', city= '"
                + getCity().trim() + "', department = '"
                + getDepartment().trim() + "'  WHERE USER_ID= " + getUser_id();
    }

    @Override
    public String delete() {
        return "DELETE FROM PERSONAL_INFORMATION WHERE USER_ID =" + getUser_id();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM PERSONAL_INFORMATION";
    }

    @Override
    public String findById() {
        return "SELECT * FROM PERSONAL_INFORMATION  WHERE USER_ID =" + getUser_id();
    }
}
