/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcspring.dao.jdbc;
import app.jdbcspring.model.Servicio;
import app.jdbcspring.dao.ServicioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */

//Primero se hace el Implements... y luego el extends
//Colocar q t sea de tipo Servicio
//pero jdbcTemplate... debe tener como parametro... tipo OBJECT
public class ServicioDAOJ extends JdbcDaoSupport implements ServicioDAO {

    public List list() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String sql = "select * from servicio";

        List<Servicio> servicios = new ArrayList<Servicio>();

        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);

        for (Map row : rows) {

            Servicio servicio = new Servicio();
            servicio.setId(Long.parseLong(String.valueOf(row.get("ID"))));
            servicio.setDescripcion((String) row.get("descripcion"));
            servicio.setCostoHora(Double.parseDouble("costoHora"));
            servicios.add(servicio); //este es SERVICIOS q es la lista en SI

        }
        return servicios;
    }

    public Servicio get(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String sql = "select * from servicio where id = ?";

        Servicio servicio = (Servicio) this.getJdbcTemplate().queryForObject(
                sql, new Object[]{t.getId()}, new ServicioRowMapper());

        return servicio;
    }

    public void save(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String sql = "insert into servicio ( descripcion, costo_hora) "
                + "values(?, ?);";

        try {

            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora()
            });

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void update(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "update servicio set descripcion=?, costo_hora=? "
                + " where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora(),
                t.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

    }

    public void delete(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getJdbcTemplate().update("delete from servicio where id=?",
                new Object[]{t.getId()});
        //update recibe 2 parametros... el sql y los argumentos..
        //id=?
        //en la linea t.getID, es el parametro q va
        //el JdbcTemplate... se encarga de abrir y cerrar la sesion
    }
    //vamos a usar la clase JDBCSupport
    //ya tiene configurado el tema de la session
    //el tema de como hacer consultas, lista, elementos, etc
    //Para Spring no puede haber 2 clases con el mismo nombre
    //pq al buscar los beans.. no podre mapearlos... ERROR
}
