/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.clases.Mes;
import modelo.interfaces.ICrud;
import conexion.Oracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giselle
 */
public class MesDAO implements ICrud<Mes> {

    // Variable de conexión hacia la BDD
    private static Connection conexion;
    // Variable statement
    private Statement st;
    // Variable resultset
    private ResultSet rs;

    @Override
    public boolean agregar(Mes e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Método listar todos los meses
    @Override
    public List<Mes> listar() {
        List<Mes> listaMeses = new ArrayList<Mes>();
        try {
            
            // Nos conectamos a la bdd
            conexion = new Oracle().getConexion();
            String consulta = "SELECT * FROM MES";
            st = conexion.createStatement();
            ResultSet r = st.executeQuery(consulta);
            while (r.next()) {
                Mes mes = new Mes();
                mes.setId(r.getInt(1));
                mes.setDescripcion(r.getString(2));
                // Agregamos el mes a la lista
                listaMeses.add(mes);
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
            return listaMeses;
        }
    }

}
