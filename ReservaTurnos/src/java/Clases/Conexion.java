/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Conexion {
    // Driver de Maria DB
    private String driver = "org.mariadb.jdbc.Driver"; // Se obtiene de la importación
    // Nombre de base de datos
    private String database = "centroautomotriz";
    // Host 
    private String host = "localhost";
    // Puerto de conexion (predeterminado 3306)
    private String port = "3306";
    
    // Ruta de conexión de base
    private String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?useSSL=false";
    
    // Usuario de base de datos (root por defecto)
    private String user = "root";
    // Contraseña (vacia por defecto)
    private String password = "";
    
    public Connection con;
    
    public void Conexion(){
        this.conectarMDB();
    }
    
    public Connection conectarMDB(){
        this.con = null;
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            System.out.print("Conexion Exitosa");
        }catch(ClassNotFoundException | SQLException error){
            System.err.println("Error " + error);
        }
        return con;
    }
    
    public String tratarData(ResultSet rs,String[] campos,String[] tipo) throws SQLException{
        String data = "["; // Inicia caneda de JSON
        int i = 0; 
        try{
            while(rs.next()){
                data += "{";
                for(i = 0;i<campos.length;i++){
                    data += "\""+campos[i]+"\":"; // Setea el campo
                    switch(tipo[i]){ // Sitch define los datos a recibir 
                        case "int":
                            data += "\""+rs.getInt(campos[i])+"\",";
                            break;
                        case "string":
                            data += "\""+rs.getString(campos[i])+"\",";
                            break;
                        default:
                            data += "\""+rs.getString(campos[i])+"\",";
                            break;
                    }
                }
                data = data.substring(0,data.length()-1); // Quita la coma del ultimo catacter
                data += "},";
            }
            data = data.substring(0,data.length()-1)+"]"; // Quita la coma del ultimo catacter
            return "{\"resp\":true,\"data\":"+data+"}"; // Retorna la información
        }catch(Exception error){
            System.err.println("Error " + error);
            return "{\"resp\":false}";
        }
    }
}
