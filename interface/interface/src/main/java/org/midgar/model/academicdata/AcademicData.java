package org.midgar.model.academicdata;


import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AcademicData implements IDto, Serializable {

    private static final long serialVersionUID = 6877796980983908907L;

    private BigDecimal User_id;
    private String scholarShip, type_of_institution;

    public AcademicData() {
    }

    public AcademicData(BigDecimal user_id, String scholarShip, String type_of_institution) {
        User_id = user_id;
        this.scholarShip = scholarShip;
        this.type_of_institution = type_of_institution;
    }

    public BigDecimal getUser_id() {
        return User_id;
    }

    public void setUser_id(BigDecimal user_id) {
        User_id = user_id;
    }

    public String getScholarShip() {
        return scholarShip;
    }

    public void setScholarShip(String scholarShip) {
        this.scholarShip = scholarShip;
    }

    public String getType_of_institution() {
        return type_of_institution;
    }

    public void setType_of_institution(String type_of_institution) {
        this.type_of_institution = type_of_institution;
    }

    @Override
    public String toString() {
        return "AcademicData{" +
                "User_id=" + User_id +
                ", scholarShip='" + scholarShip + '\'' +
                ", type_of_institution='" + type_of_institution + '\'' +
                '}';
    }

    @Override
    public String insert() {
        return "INSERT INTO ACADEMIC_DATA ( user_id, scholarship, type_of_institution) VALUES("
                + getUser_id() + ",'"
                + getScholarShip().trim() + "','"
                + getType_of_institution().trim() + "')";
    }

    @Override
    public String update() {
        return "UPDATE ACADEMIC_DATA SET scholarship = '" + getScholarShip().trim()
                + "', type_of_institution = '" + getType_of_institution().trim()
                + "' WHERE USER_ID = " + getUser_id();
    }

    @Override
    public String delete() {
        return "DELETE FROM ACADEMIC_DATA WHERE USER_ID =" + getUser_id();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM ACADEMIC_DATA";
    }

    @Override
    public String findById() {
        return "SELECT * FROM ACADEMIC_DATA WHERE USER_ID = " + getUser_id();
    }
}
