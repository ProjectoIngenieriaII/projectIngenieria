/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.TipoServicioModel;

/**
 *
 * @author USUARIO
 */
public class TipoServicioClass {
    
    TipoServicioModel servicio = new TipoServicioModel();
    
      public String listarData(int idSucursal){
        return servicio.getData(idSucursal);
    }
    
}
