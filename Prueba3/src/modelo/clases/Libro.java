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
public class Libro extends Documento {

    private boolean prestamo;

    public Libro() {
    }

    public Libro(boolean prestamo, int codigo, String titulo, String autor, String editorial, String anio) {
        super(codigo, titulo, autor, editorial, anio);
        this.prestamo = prestamo;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Libro{" + "prestamo=" + prestamo + '}';
    }

    public String imprimir() {
        
        String valida = "No.";
        System.out.println("--------------------------------");
        System.out.println("            LIBRO");
        System.out.println("--------------------------------");
        System.out.println("Código : " + super.getCodigo());
        System.out.println("Título : " + super.getTitulo());
        System.out.println("Autor : " + super.getAutor());
        System.out.println("Editorial : " + super.getEditorial());
        System.out.println("Año : " + super.getAnio());
        if(this.prestamo){
            valida = "Sí.";
        }
        System.out.println("Prestamo : " + valida);
        
        String texto = "LIBRO - Código : " + super.getCodigo() + " Título : " + super.getTitulo() + " Autor : " + super.getAutor() + " Editorial : " + super.getEditorial() + " Año : " + super.getAnio() + " Prestamo " + valida;
        return texto;
    }

}
