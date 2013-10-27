/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcspring.test;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbcspring.model.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class AppTest {

    public static void main(String[] args) {
        AppTest.saveServicio();
    }
    
    public static void saveServicio() {
        //decimos utiliza esta configuracion... jdbc_database.xml
        //con esto ya estamos trayendo el contexto de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        
        //Spring va instanciar el bean (objeto) y lo ha instanciado
        //en el jdbc_database.xml
        //y le pedimos al contexto q nos devuelva al contexto q esta instaciado
        //("servicioDAO") <<--- es el ID q fue declarado en el xml
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setDescripcion("Local Rimac");
        servicio.setCostoHora(70.00);

        servicioDAO.save(servicio);
    }
    

}
