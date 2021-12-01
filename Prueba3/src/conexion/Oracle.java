/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Giselle
 */
public class Oracle {
    private Connection conexion = null;
    private String url, user, pass;

    public Oracle() {
        conectar();
    }
    
    
    
    private void conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // Driver BD
            url = "jdbc:oracle:thin:@localhost:1521:orcl";
            user = "prueba3";
            pass = "prueba3";
            conexion = DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("Error al intentar conectarse! " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar! " + e.getMessage());
        }
    }
    
}
