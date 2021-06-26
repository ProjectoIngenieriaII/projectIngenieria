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
 * @author ASUS
 */
public class UsuarioModel extends Conexion{
    
    Connection conn = conectarMDB();
    
    public String verificar(int user, String password){
        try{
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM clientes WHERE nro_doc_cliente = ? AND contrasena = ?");
            consulta.setInt(1, user);
            consulta.setString(2, password);
            ResultSet rs = consulta.executeQuery();
            
            if(rs.next()){
                return "[{\"resp\":true},{\"user\":"+user+"}]";
            }
            return "[{\"resp\":false}]";
        }catch(Exception e){
            System.out.println("Error: "+ e + "Error aqui");
            return "[{\"resp\":false}]";
        }
    }
}
