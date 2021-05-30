/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.CiudadModel;

/**
 *
 * @author ASUS
 */
public class CiudadClass {
    CiudadModel ciudad = new CiudadModel();
    
    public String listarData(int depto){
        return ciudad.getData(depto);
    }
}
