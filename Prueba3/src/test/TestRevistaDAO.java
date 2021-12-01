/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import modelo.clases.Mes;
import modelo.clases.Revista;
import modelo.dao.RevistaDAO;

/**
 *
 * @author Giselle
 */
public class TestRevistaDAO {

    public static void main(String[] args) {
        RevistaDAO dao = new RevistaDAO();
        Mes mes = new Mes(1);
        Revista revista = new Revista("Grande", "23", mes, 2, "Monas chinas", "uwu", "La marmota", "2013");
        // AGREGAR REVISTA
//        if (dao.agregar(revista)) {
//            System.out.println("AGREGADO!");
//        }

        // Eliminar REVISTA
        if (dao.eliminar(9999)) {
            System.out.println("Eliminado!");
        }
//        List<Revista> listaRevistas = dao.listar();
//
//        // Listar REVISTAS
//        for (Revista x : listaRevistas) {
//            System.out.println("Revistas : " + x.getTitulo());
//        }
        
    }
}
