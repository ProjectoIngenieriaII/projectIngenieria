/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.UsuarioModel;

/**
 *
 * @author ASUS
 */
public class UsuarioClass {
    
    UsuarioModel modelo = new UsuarioModel();
    
    public String verificarUsuario(int usuario,String password){
        return modelo.verificar(usuario,password);
    }
}
