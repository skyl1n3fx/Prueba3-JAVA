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
public class Documento {
    // Atributos generales de documento
    private int codigo; 
    private String titulo, autor, editorial, anio;

    public Documento() {
    }

    public Documento(int codigo, String titulo, String autor, String editorial, String anio) {
        setCodigo(codigo);
        setTitulo(titulo);
        setAutor(autor);
        setEditorial(editorial);
        setAnio(anio);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Documento{" + "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", anio=" + anio + '}';
    }
    
    
    
}
