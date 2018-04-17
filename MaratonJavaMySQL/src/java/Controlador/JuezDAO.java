/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class JuezDAO extends UsuarioDAO {
    
    Session session = null;
    
    public void StartMarathon(int idmaraton){
  
    }
    
    public void FinishMarathon(int idmaraton){
        
    }
    
    public boolean setUsserPenalty(){
        boolean pusser = false;
    
        try{
            
        }catch (Exception e){
            e.printStackTrace();   
    }return pusser;}
}
