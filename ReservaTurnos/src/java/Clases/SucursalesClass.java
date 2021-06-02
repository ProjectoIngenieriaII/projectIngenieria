/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.SucursalesModel;

/**
 *
 * @author USUARIO
 */
public class SucursalesClass {
    SucursalesModel sucursal = new SucursalesModel();
    
       public String listarData(int idCiudad){
        return sucursal.getData(idCiudad);
    }
}
