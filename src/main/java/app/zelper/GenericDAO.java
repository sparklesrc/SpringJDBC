/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.zelper;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface GenericDAO<T> {
    //Cuando ponemos <T> decimos q va trabajar con la clase Cualquiera
    //El generic se debe repetir en todos los DAO
    //no deberia haber un getByCampo pq eso ya es especifico del DAO
    //como vamos a tener varios DAO
    //con el service diremos quien es quien

    public List<T> list();

    public T get(T t);

    public void save(T t);

    public void update(T t);

    public void delete(T t);
}
