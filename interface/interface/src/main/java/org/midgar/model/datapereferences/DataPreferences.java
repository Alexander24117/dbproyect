package org.midgar.model.datapereferences;

import org.midgar.model.proyect.idto.IDto;

import java.io.Serializable;

public class DataPreferences implements IDto, Serializable {

    private static final long serialVersionUID = 7400183906825132092L;

    private Integer user_Id;
    private String favoriteColor, musicalGenre, hobby, sportsTalent, musicalTalent, artisticTalent;

    public DataPreferences(Integer user_Id,
                           String favoriteColor,
                           String musicalGenre,
                           String hobby,
                           String sportsTalent,
                           String musicalTalent,
                           String artisticTalent) {
        this.user_Id = user_Id;
        this.favoriteColor = favoriteColor;
        this.musicalGenre = musicalGenre;
        this.hobby = hobby;
        this.sportsTalent = sportsTalent;
        this.musicalTalent = musicalTalent;
        this.artisticTalent = artisticTalent;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSportsTalent() {
        return sportsTalent;
    }

    public void setSportsTalent(String sportsTalent) {
        this.sportsTalent = sportsTalent;
    }

    public String getMusicalTalent() {
        return musicalTalent;
    }

    public void setMusicalTalent(String musicalTalent) {
        this.musicalTalent = musicalTalent;
    }

    public String getArtisticTalent() {
        return artisticTalent;
    }

    public void setArtisticTalent(String artisticTalent) {
        this.artisticTalent = artisticTalent;
    }

    @Override
    public String insert() {
        return "INSERT INTO DATA_PREFERENCES (user_id, favorite_color, musical_genre, hobby, sports_talent, musical_talent, artistic_talent) VALUES(' "
                +getUser_Id()+"','"
                +getFavoriteColor().trim()+"','"
                +getMusicalGenre().trim()+"','"
                +getHobby().trim()+"','"
                +getSportsTalent().trim()+"','"
                +getMusicalTalent().trim()+"','"
                +getArtisticTalent().trim()+"');";

    }

    @Override
    public String update() {
        return "UPDATE ACADEMIC_DATA SET favorite_color = '"+getFavoriteColor().trim()
                +"', musical_genre = ' "+ getMusicalGenre().trim()
                +"', hobby = ' "+getHobby().trim()
                +"', sports_talent = ' "+getSportsTalent().trim()
                +"', musical_talent = ' "+ getMusicalTalent().trim()
                +"', artistic_talent= ' "+ getArtisticTalent().trim()
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
