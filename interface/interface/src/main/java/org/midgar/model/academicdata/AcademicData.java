package org.midgar.model.academicdata;

import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;

public class AcademicData implements IDto, Serializable {

    private static final long serialVersionUID = 6877796980983908907L;

    private Integer User_ID;
    private String scholarShip, typeOfInstitution;

    public AcademicData(Integer user_ID, String scholarShip, String typeOfInstitution) {
        User_ID = user_ID;
        this.scholarShip = scholarShip;
        this.typeOfInstitution = typeOfInstitution;
    }

    public Integer getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }

    public String getScholarShip() {
        return scholarShip;
    }

    public void setScholarShip(String scholarShip) {
        this.scholarShip = scholarShip;
    }

    public String getTypeOfInstitution() {
        return typeOfInstitution;
    }

    public void setTypeOfInstitution(String typeOfInstitution) {
        this.typeOfInstitution = typeOfInstitution;
    }

    @Override
    public String toString() {
        return "AcademicData{" +
                "User_ID=" + User_ID +
                ", scholarShip='" + scholarShip + '\'' +
                ", typeOfInstitution='" + typeOfInstitution + '\'' +
                '}';
    }

    @Override
    public String insert() {
        return "INSERT INTO ACADEMIC_DATA ( user_id, scholarship, type_of_institution) VALUES('"
                + getUser_ID() + "','"
                + getScholarShip().trim() + "','"
                + getTypeOfInstitution().trim() + "');";
    }

    @Override
    public String update() {
        return "UPDATE ACADEMIC_DATA SET scholarship = '" + getScholarShip().trim()
                + "', type_of_institution = '" + getTypeOfInstitution().trim()
                + "' WHERE USER_ID = " + getUser_ID();
    }

    @Override
    public String delete() {
        return "DELETE FROM ACADEMIC_DATA WHERE USER_ID =" + getUser_ID();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM ACADEMIC_DATA";
    }

    @Override
    public String findById() {
        return "SELECT * FROM ACADEMIC_DATA WHERE USER_ID = " + getUser_ID();
    }
}
