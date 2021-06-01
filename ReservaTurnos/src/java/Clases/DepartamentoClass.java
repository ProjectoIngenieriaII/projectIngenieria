/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.DepartamentoModel;

/**
 *
 * @author ASUS
 */
public class DepartamentoClass {
    DepartamentoModel modelo = new DepartamentoModel(0,"");
    
    public String listar(){
        return modelo.getData();
    }
}
