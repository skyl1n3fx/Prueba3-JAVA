/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import modelo.clases.Mes;
import modelo.dao.MesDAO;

/**
 *
 * @author Giselle
 */
public class TestMesDAO {
    public static void main(String[] args) {
        MesDAO dao = new MesDAO();
        List<Mes> listaMeses = dao.listar();
            
        // Listar meses
        for(Mes x : listaMeses){
            System.out.println("Mes : " + x.getDescripcion());
        }
        
    }
}
