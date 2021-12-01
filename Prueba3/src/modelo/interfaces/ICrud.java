/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import java.util.List;

/**
 *
 * @author Giselle
 */
public interface ICrud <Entidad>{
    
    // Método agregar entidad
    boolean agregar(Entidad e);
    
    // Método eliminar por ID
    boolean eliminar(int id);
    
    // Método listar
    List<Entidad> listar();
    
}
