package org.midgar.test;

import org.midgar.model.academicdata.AcademicData;
import org.midgar.model.academicdata.AcademicDataDao;

import java.math.BigDecimal;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        new App();
    }

    public App() {

        BigDecimal n = BigDecimal.valueOf(1);
        AcademicDataDao academicDataDao = new AcademicDataDao();
        AcademicData academicData = new AcademicData(n,"prueba","prueba");
        System.out.println(academicData.insert());
        academicDataDao.insert(academicData);


        Date date = new Date();
        System.out.println(date.toString());
    }
}
