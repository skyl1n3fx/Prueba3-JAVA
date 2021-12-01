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
import modelo.clases.Mes;
import modelo.clases.Revista;
import modelo.interfaces.ICrud;

/**
 *
 * @author Giselle
 */
public class RevistaDAO implements ICrud<Revista> {

    // Acceso a la BD
    private static Connection conexion;
    // Prepared statement para hacer INSERT, UPDATE, DELETE
    private PreparedStatement ps = null;
    // Variable statement
    private Statement st;
    // Variable resultset
    private ResultSet rs;

    @Override
    public boolean agregar(Revista e) {
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
            // INSERTAR EN REVISTA
            sql = "INSERT INTO REVISTA VALUES (?,?,?,?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getVolumen());
            ps.setString(3, e.getNumero());
            ps.setInt(4, e.getMes().getId());
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
            String sql = "DELETE FROM REVISTA WHERE CODIGO = ?";
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
    public List<Revista> listar() {
        List<Revista> listaRevistas = new ArrayList<Revista>();
        boolean prestamo = false;
        try {
            // Nos conectamos a la bdd
            conexion = new Oracle().getConexion();
            String consulta = "SELECT * FROM DOCUMENTO d INNER JOIN REVISTA r ON d.codigo = r.codigo INNER JOIN MES m ON r.mes_id = m.id";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Revista revista = new Revista();
                revista.setCodigo(rs.getInt(1));
                revista.setTitulo(rs.getString(2));
                revista.setAutor(rs.getString(3));
                revista.setEditorial(rs.getString(4));
                revista.setAnio(rs.getString(5));
                revista.setVolumen(rs.getString(7));
                revista.setNumero(rs.getString(8));
                Mes mes = new Mes(rs.getInt(9),rs.getString(11));
                revista.setMes(mes);
                // Agregamos el libro a la lista
                listaRevistas.add(revista);
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
            return listaRevistas;
        }
    }

}
