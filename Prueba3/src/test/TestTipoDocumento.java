/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import modelo.clases.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;

/**
 *
 * @author Giselle
 */
public class TestTipoDocumento {
    public static void main(String[] args) {
        TipoDocumentoDAO dao = new TipoDocumentoDAO();
        
        List<TipoDocumento> listaTipoDocumentos = dao.listar();
        
        for(TipoDocumento x : listaTipoDocumentos){
            System.out.println("TIPO : " + x.getDescripcion());
        }
    }
}
