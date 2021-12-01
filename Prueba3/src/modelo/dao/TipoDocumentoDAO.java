/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Oracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.clases.TipoDocumento;
import modelo.interfaces.ICrud;

/**
 *
 * @author Giselle
 *
 */
public class TipoDocumentoDAO implements ICrud<TipoDocumento> {
    // Variable de conexión hacia la BDD

    private static Connection conexion;
    // Variable statement
    private Statement st;
    // Variable resultset
    private ResultSet rs;

    @Override
    public boolean agregar(TipoDocumento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> listar() {
        List<TipoDocumento> listaTipoDocumento = new ArrayList<TipoDocumento>();
        try {
            // Nos conectamos a la bdd
            conexion = new Oracle().getConexion();
            String consulta = "SELECT * FROM TIPO_DOCUMENTO";
            st = conexion.createStatement();
            ResultSet r = st.executeQuery(consulta);
            while (r.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setId(r.getInt(1));
                tipoDocumento.setDescripcion(r.getString(2));
                // Agregamos el tipo de documento a la lista
                listaTipoDocumento.add(tipoDocumento);
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
            return listaTipoDocumento;
        }
    }

}
