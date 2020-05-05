package org.midgar.model.personalinformation;

import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;
import java.util.Date;

public class PersonalInfo implements IDto, Serializable {

    private static final long serialVersionUID = 3440684777140763445L;

    Integer user_ID, shirt_size, pants_size, shoes_size;
    String gender, city, department;
    Date birthdate;

    public PersonalInfo(Integer user_ID,
                        Integer shirt_size,
                        Integer pants_size,
                        Integer shoes_size,
                        String gender, String city, String department,
                        Date birthdate) {
        this.user_ID = user_ID;
        this.shirt_size = shirt_size;
        this.pants_size = pants_size;
        this.shoes_size = shoes_size;
        this.gender = gender;
        this.city = city;
        this.department = department;
        this.birthdate = birthdate;
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public Integer getShirt_size() {
        return shirt_size;
    }

    public void setShirt_size(Integer shirt_size) {
        this.shirt_size = shirt_size;
    }

    public Integer getPants_size() {
        return pants_size;
    }

    public void setPants_size(Integer pants_size) {
        this.pants_size = pants_size;
    }

    public Integer getShoes_size() {
        return shoes_size;
    }

    public void setShoes_size(Integer shoes_size) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "user_ID=" + user_ID +
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
        return "INSET INTO PERSONAL_INFORMATION (user_id, gender, birthdate, shirt_size, pants_size, shoes_size, city, deparment) VALUES('"
                + getUser_ID() + "','"
                + getGender().trim() + "','"
                + getBirthdate() + "','"
                + getShirt_size() + "','"
                + getPants_size() + "','"
                + getShoes_size() + "','"
                + getCity().trim() + "','"
                + getDepartment().trim() + "');";
    }

    @Override
    public String update() {
        return "UPDATE PERSONAL_INFORMATION SET gender= '" + getGender().trim() + "', shirt_size ='"
                + getShirt_size() + "', pants_size= '"
                + getPants_size() + "', shoes_size= '"
                + getShoes_size() + "', city= '"
                + getCity().trim() + "', department = '"
                + getDepartment().trim() + "'  WHERE USER_ID= " + getUser_ID();
    }

    @Override
    public String delete() {
        return "DELETE FROM PERSONAL_INFORMATION WHERE USER_ID =" + getUser_ID();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM PERSONAL_INFORMATION";
    }

    @Override
    public String findById() {
        return "SELECT * FROM REGISTRO  WHERE USER_ID =" + getUser_ID();
    }
}
