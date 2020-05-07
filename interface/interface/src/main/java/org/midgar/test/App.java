package org.midgar.test;

import org.midgar.model.personalinformation.PersonalInformation;
import org.midgar.model.personalinformation.PersonalInfoDao;
import org.midgar.model.proyect.idto.IDto;
import org.midgar.model.registro.Registro;
import org.midgar.model.registro.RegistroDao;
import org.midgar.model.server.RequestIdentifier;

import java.math.BigDecimal;
import java.util.Date;

public class App extends RequestIdentifier {

    public static void main(String[] args) {
        new App();
    }

    public App() {
        System.out.println("----------");
        // OracleConnection.getInstance();
        BigDecimal n = BigDecimal.valueOf(1);
        Registro registro = new Registro(n, "prueba", "prueba", "prueba", "prueba");
        RegistroDao registroDao = new RegistroDao();
        IDto seo = registroDao.getById(registro);
        System.out.println(seo.toString());
        System.out.println("------------");
        String peticion = Registro.class.getName() + "#" + registro.findById();
        System.out.println(peticion);
        Object rs = requestIdentifier(peticion);
        System.out.println(rs.toString());
        System.out.println("------------------------------------------");
        PersonalInformation personalInformation = new PersonalInformation(n, n, n, n, "prueba", "prueba", "prueba", "prueba");
        System.out.println(personalInformation.findById());
        PersonalInfoDao personalInfoDao = new PersonalInfoDao();
        Object ol = personalInfoDao.getById(personalInformation);
        System.out.println(ol.toString());
        System.out.println("------------------------------------------");
        String busqueda = PersonalInformation.class.getName()+"#"+personalInformation.findById();
        Object lo = requestIdentifier(busqueda);
        System.out.println(lo.toString());
        Date date = new Date();
        System.out.println(date.toString());
    }
}
