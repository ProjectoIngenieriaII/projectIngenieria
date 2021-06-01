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
public class DepartamentoModel extends Conexion{
    
    public int idDepto;
    public String nombreDepto;
    Connection conn = conectarMDB();

    
    public DepartamentoModel(int depto,String nombre){
        this.idDepto = depto;
        this.nombreDepto = nombre;
    }
    
    public String getData(){
        try{
            
            PreparedStatement consulta = conn.prepareStatement("SELECT * FROM departamentos");
            
            ResultSet rs = consulta.executeQuery();
            ResultSet rs2 = consulta.executeQuery(); // Conteiene toda la data origina
            if(rs.next()){ // Verifica que si tenga datos la consulta
                String[] campos = new String[2]; // Se crea según la cantidad de campos de la taba 
                campos[0] = "id_depto"; // Primer campo de la tabla
                campos[1] = "nom_depto"; // Segundo campo de la tabla
                String[] tipo = new String[2]; // Se crea según la cantidad de campos de la taba y para definir el tipo de dato
                tipo[0] = "int";  // Tipo de dato del Primer campo de la tabla
                tipo[1] = "string";  // Tipo de dato del segundo campo de la tabla
                String respuesta = tratarData(rs2,campos,tipo); // Se llama a la función para tratar la información y retornarla como JSON
                return respuesta;
            }else{
                return "{\"resp\":false}"; // Respuesta Json Para cuando no trae información
            }            
        }catch(Exception e){
            System.out.println("Error: "+ e);
            return "{\"resp\":false}";
        }        
    }
}
