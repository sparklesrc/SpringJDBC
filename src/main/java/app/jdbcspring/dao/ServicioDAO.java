/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.jdbcspring.dao;

import app.jdbcspring.model.Servicio;
import app.zelper.GenericDAO;

/**
 *
 * @author Administrador
 */
public interface ServicioDAO extends GenericDAO<Servicio>{
    
    /*ServicioDAO debe heredar de GenericDAO
     * Caracteristicas de esta clase:
     * provee desacoplamiento
     * dicta el dao de quien... qué va hacer
     * y q hereda del generic
     */
    
    
}
