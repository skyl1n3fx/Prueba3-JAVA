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
public class Revista extends Documento {

    private String volumen, numero;
    private Mes mes;

    public Revista(String volumen, String numero, Mes mes, int codigo, String titulo, String autor, String editorial, String anio) {
        super(codigo, titulo, autor, editorial, anio);
        setVolumen(volumen);
        setNumero(numero);
        setMes(mes);
    }

    public Revista() {
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Revista{" + super.toString() +  " volumen=" + volumen + ", numero=" + numero + ", mes=" + mes + '}';
    }

    public String imprimir() {
        String texto = "REVISTA - Código : " + super.getCodigo() + " Título : " + super.getTitulo() + " Autor : " + super.getAutor() + " Editorial : " + super.getEditorial() + " Año : " + super.getAnio() + " Volumen : " + this.volumen + " Número : " + this.numero + " Mes : " + this.mes.getDescripcion();
        System.out.println("--------------------------------");
        System.out.println("            REVISTA");
        System.out.println("--------------------------------");
        System.out.println("Código : " + super.getCodigo());
        System.out.println("Título : " + super.getTitulo());
        System.out.println("Autor : " + super.getAutor());
        System.out.println("Editorial : " + super.getEditorial());
        System.out.println("Año : " + super.getAnio());
        System.out.println("Volumen : " + this.volumen);
        System.out.println("Número : " + this.numero);
        System.out.println("Mes : " + this.mes.getDescripcion());
        return texto;
    }
}
