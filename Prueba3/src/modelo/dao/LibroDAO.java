/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.clases.Documento;
import modelo.clases.Libro;
import modelo.clases.Mes;
import modelo.interfaces.ICrud;

/**
 *
 * @author Giselle
 */
public class LibroDAO implements ICrud<Libro> {

    // Acceso a la BD
    private static Connection conexion;
    // Prepared statement para hacer INSERT, UPDATE, DELETE
    private PreparedStatement ps = null;
    // Variable statement
    private Statement st;
    // Variable resultset
    private ResultSet rs;

    @Override
    public boolean agregar(Libro e) {
        int prestamo = 2;
        boolean valida = false;
        try {
            conexion = new Oracle().getConexion();
            // INSERTAR EN DOCUMENTO
            String sql = "INSERT INTO DOCUMENTO VALUES (?,?,?,?,?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getAutor());
            ps.setString(4, e.getEditorial());
            ps.setString(5, e.getAnio());
            ps.execute();
            // INSERTAR EN LIBRO
            sql = "INSERT INTO LIBRO VALUES (?,?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, e.getCodigo());
            if (e.isPrestamo()) {
                prestamo = 1;
            }
            ps.setInt(2, prestamo);
            ps.execute();
            valida = true;
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                /* Ignored */ }
            try {
                st.close();
            } catch (Exception ex) {
                /* Ignored */ }
            try {
                conexion.close();
            } catch (Exception ex) {
                /* Ignored */ }
            return valida;
        }
    }

    @Override
    public boolean eliminar(int id) {
        boolean valida = false;
        try {
            // Conexión
            conexion = new Oracle().getConexion();
            // Eliminar el libro
            String sql = "DELETE FROM LIBRO WHERE CODIGO = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            // Eliminar el documento
            sql = "DELETE FROM DOCUMENTO WHERE CODIGO = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int x = ps.executeUpdate();
            if (x == 1) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                /* Ignored */ }
            try {
                st.close();
            } catch (Exception ex) {
                /* Ignored */ }
            try {
                conexion.close();
            } catch (Exception ex) {
                /* Ignored */ }
            return valida;
        }
    }

    @Override
    public List<Libro> listar() {
        List<Libro> listaLibros = new ArrayList<Libro>();
        boolean prestamo = false;
        try {
            // Nos conectamos a la bdd
            conexion = new Oracle().getConexion();
            String consulta = "SELECT * FROM DOCUMENTO d INNER JOIN LIBRO l ON d.codigo = l.codigo";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setCodigo(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setAutor(rs.getString(3));
                libro.setEditorial(rs.getString(4));
                libro.setAnio(rs.getString(5));
                if (rs.getInt(7) == 1) {
                    prestamo = true;
                }
                libro.setPrestamo(prestamo);
                // Agregamos el libro a la lista
                listaLibros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                st.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                conexion.close();
            } catch (Exception e) {
                /* Ignored */ }
            return listaLibros;
        }
    }

}
