/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;

/**
 *
 * @author admin
 * 
 * @TODO:
 * >Registrar(✓) 
 * >Eliminar Registro(✓)
 * >Log In()
 * >Log Out()
 * >Inscribir(✓?)[se]
 * >Desinscribir(✓)[se]
 * >Comprobar Participación(✓?)
 * >Ver maratón(✓)
 * >Modificar Datos()
 * >Ver Clasificación()
 */

interface InterfazBase {

    boolean Registrar(); 
         
    void UnRegister();
            
    boolean LogIn();
    
    void LogOut();
       
    List ViewEnrollment();
    
    List ViewMarathon();
    
    boolean UpdateData();
    
    List ViewClasification();
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}       
