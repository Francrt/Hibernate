/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
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
         
    boolean UnRegister();
            
    void LogIn();
    
    void LogOut();
       
    boolean ConsultaInscripcion();
    
    void VerMaratones();
    
    boolean ModificarDatos();
    
    void VerClasificación();
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
}       
