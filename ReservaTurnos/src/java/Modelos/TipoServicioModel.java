/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class TipoServicioModel extends Conexion{
     
          Connection conn = conectarMDB();
    
    public String getData(int idSucursal){
        try{
            
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM servicios WHERE id_sucursal = ?");
            consulta.setInt(1, idSucursal);
            
            ResultSet rs = consulta.executeQuery();
            ResultSet rs2 = consulta.executeQuery(); // Conteiene toda la data origina
            if(rs.next()){
                String[] campos = new String[2];
                campos[0] = "id_servicio";
                campos[1] = "nom_servicio";
                String[] tipo = new String[2];
                tipo[0] = "int";
                tipo[1] = "string";
                return tratarData(rs2,campos,tipo);
            }else{
                return "{\"resp\":false}";
            }
        }catch(Exception e){
            System.out.println("Error: "+ e);
            return "{\"resp\":false}";
        }
    }

}
