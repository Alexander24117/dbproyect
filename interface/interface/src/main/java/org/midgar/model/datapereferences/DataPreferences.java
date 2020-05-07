package org.midgar.model.datapereferences;

import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DataPreferences implements IDto, Serializable {

    private static final long serialVersionUID = 7400183906825132092L;

    private BigDecimal user_Id;
    private String favorite_color, musical_genre, hobby, sports_talent, musical_talent, artistic_talent;

    public DataPreferences() {
    }

    public DataPreferences(BigDecimal user_Id,
                           String favorite_color,
                           String musical_genre,
                           String hobby,
                           String sports_talent,
                           String musical_talent,
                           String artistic_talent) {
        this.user_Id = user_Id;
        this.favorite_color = favorite_color;
        this.musical_genre = musical_genre;
        this.hobby = hobby;
        this.sports_talent = sports_talent;
        this.musical_talent = musical_talent;
        this.artistic_talent = artistic_talent;
    }

    public BigDecimal getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(BigDecimal user_Id) {
        this.user_Id = user_Id;
    }

    public String getFavorite_color() {
        return favorite_color;
    }

    public void setFavorite_color(String favorite_color) {
        this.favorite_color = favorite_color;
    }

    public String getMusical_genre() {
        return musical_genre;
    }

    public void setMusical_genre(String musical_genre) {
        this.musical_genre = musical_genre;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSports_talent() {
        return sports_talent;
    }

    public void setSports_talent(String sports_talent) {
        this.sports_talent = sports_talent;
    }

    public String getMusical_talent() {
        return musical_talent;
    }

    public void setMusical_talent(String musical_talent) {
        this.musical_talent = musical_talent;
    }

    public String getArtistic_talent() {
        return artistic_talent;
    }

    public void setArtistic_talent(String artistic_talent) {
        this.artistic_talent = artistic_talent;
    }

    @Override
    public String toString() {
        return "DataPreferences{" +
                "user_Id=" + user_Id +
                ", favorite_color='" + favorite_color + '\'' +
                ", musical_genre='" + musical_genre + '\'' +
                ", hobby='" + hobby + '\'' +
                ", sports_talent='" + sports_talent + '\'' +
                ", musical_talent='" + musical_talent + '\'' +
                ", artistic_talent='" + artistic_talent + '\'' +
                '}';
    }

    @Override
    public String insert() {
        return "INSERT INTO DATA_PREFERENCES (user_id, favorite_color, musical_genre, hobby, sports_talent, musical_talent, artistic_talent) VALUES( "
                +getUser_Id()+",'"
                + getFavorite_color().trim()+"','"
                + getMusical_genre().trim()+"','"
                +getHobby().trim()+"','"
                + getSports_talent().trim()+"','"
                + getMusical_talent().trim()+"','"
                + getArtistic_talent().trim()+"')";

    }

    @Override
    public String update() {
        return "UPDATE ACADEMIC_DATA SET favorite_color = '"+ getFavorite_color().trim()
                +"', musical_genre = ' "+ getMusical_genre().trim()
                +"', hobby = ' "+getHobby().trim()
                +"', sports_talent = ' "+ getSports_talent().trim()
                +"', musical_talent = ' "+ getMusical_talent().trim()
                +"', artistic_talent= ' "+ getArtistic_talent().trim()
                +"' WHERE user_id = "+ getUser_Id();
    }

    @Override
    public String delete() {
        return "DELETE FROM DATA_PREFERENCES WHERE user_id = "+ getUser_Id();
    }

    @Override
    public String findAll() {
        return "SELECT * FROM DATA_PREFERENCES";
    }

    @Override
    public String findById() {
        return "SELECT * FROM DATA_PREFERENCES WHERE user_id = "+ getUser_Id();
    }
}
