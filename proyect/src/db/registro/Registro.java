package db.registro;

import db.proyect.idto.IDto;

import java.io.Serializable;

public class Registro implements IDto, Serializable {

    private static final long serialVersionUID = 3568242047161152104L;
    private Integer user_Id;
    private String name, user_Name, password, state;


    public Registro() {
    }

    public Registro(Integer user_Id, String name, String user_Name, String password, String state) {
        this.user_Id = user_Id;
        this.name = name;
        this.user_Name = user_Name;
        this.password = password;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "user_Id=" + user_Id +
                ", name='" + name + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public String insert() {
         return "INSERT INTO REGISTRO (user_id, name, username, password, status) VALUES('"
                + getUser_Id() + "','"
                + getName().trim() + "','"
                + getUser_Name().trim() + "','"
                + getPassword().trim() + "','"
                + getState().trim() + "');";
    }

    @Override
    public String update() {
        return "UPDATE REGISTRO SET USERNAME"+ getName()+"WHERE USER_ID = "+getUser_Id();
    }

    @Override
    public String delete() {
        return "DELETE FROM REGISTRO WHERE USER_ID = "+getUser_Id();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM REGISTRO";
    }

    @Override
    public String findById() {
        return "SELECT * FROM REGISTRO WHERE USER_ID = "+ getUser_Id();
    }


}
