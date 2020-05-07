package org.midgar.model.personalinformation;


import org.midgar.model.proyect.idao.AbstractDao;

public class PersonalInfoDao extends AbstractDao<PersonalInformation> {
    public PersonalInfoDao() {
        super(PersonalInformation.class);
    }
}
