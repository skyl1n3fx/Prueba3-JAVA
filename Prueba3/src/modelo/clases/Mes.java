/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.clases;

/**
 *
 * @author Giselle
 */
public class Mes{
    private int id;
    private String descripcion;

    public Mes() {
    }

    public Mes(int id) {
        this.id = id;
    }
    
    public Mes(int id, String descripcion) {
        setId(id);
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Mes{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }    
    
}
