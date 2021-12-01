/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import modelo.clases.Libro;
import modelo.dao.LibroDAO;

/**
 *
 * @author Giselle
 */
public class TestLibroDAO {

    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();
        Libro libro = new Libro(false, 101, "Hanna", "Montana", "uwuwu", "2021");
        // AGREGAR LIBRO
//        if (dao.agregar(libro)) {
//            System.out.println("AGREGADO!");
//        }

        // Eliminar libro
        if (dao.eliminar(7)) {
            System.out.println("Eliminado!");
        }else{
            System.out.println("No eliminado");
        }

//        List<Libro> listaLibros = dao.listar();
//            
//        // Listar meses
//        for(Libro x : listaLibros){
//            System.out.println("Libro : " + x.getTitulo());
//        }

    }
}
