package org.midgar.model.registro;

import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Registro implements IDto, Serializable {

    private static final long serialVersionUID = 3568242047161152104L;
    private BigDecimal user_id;
    private String name;
    private String username;
    private String password;
    private String status;


    public Registro() {
    }

    public Registro(BigDecimal user_id, String name, String username, String password, String status) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public BigDecimal getUser_id() {
        return user_id;
    }

    public void setUser_id(BigDecimal user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + status + '\'' +
                '}';
    }

    @Override
    public String insert() {
        return "INSERT INTO REGISTRO(user_id, name,username, password, status) VALUES("
                + getUser_id()+",'"
                + getName().trim() + "','"
                + getUsername().trim() + "','"
                + getPassword().trim() + "','"
                + getStatus().trim() + "')";
    }

    @Override
    public String update() {
        return "UPDATE REGISTRO SET USERNAME = '" + getName() + "' WHERE USER_ID = " + getUser_id();
    }

    @Override
    public String delete() {
        return "DELETE FROM REGISTRO WHERE USER_ID = " + getUser_id();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM REGISTRO";
    }

    @Override
    public String findById() {
        return "SELECT * FROM REGISTRO WHERE USER_ID = " + getUser_id();
    }


}
