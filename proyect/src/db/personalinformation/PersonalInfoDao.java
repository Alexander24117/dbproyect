package db.personalinformation;

import db.proyect.idao.AbstractDao;

public class PersonalInfoDao extends AbstractDao<PersonalInfo> {
    public PersonalInfoDao() {
        super(PersonalInfo.class);
    }
}
