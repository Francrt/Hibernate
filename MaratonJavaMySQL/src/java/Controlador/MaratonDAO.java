/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConectaDB;
import Modelo.Juez;
import Modelo.Usuario;
import Modelo.Maraton;
import Controlador.AdministradorDAO;
import Controlador.UsuarioDAO;
import Controlador.JuezDAO;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;




/**
 *
 * @author admin
 */
public class MaratonDAO {
    
    private ConectaDB conection;
    int IDUsser;
    int Mark;
    HashMap<Usuario, Maraton> Run;
    HashMap<Juez, Maraton> Control;
    HashMap<Integer, Integer> Clasification;
   
    
    /*
    El siguiente método deberia consultarse tanto cuando el Administrador
    quiera inscribir a un usuario en un maratón, como cuando un usuario se 
    quiera inscribir. El método busca en la base de datos por ID y devuelve un 
    FALSE si no está inscrito y TRUE si ya está inscrito en el maratón.
    */
    
     public boolean HearSign(int IDUsser){
        Connection con = conection.conect();
        boolean registered = false;
        Statement stm;
        ResultSet rs;
        // SQL's Sentence
        String sql = "SELECT * FROM usuariomaraton where IDUsuario="+IDUsser+"";
        // Run SQL's Sentence
        
        try {
            con = conection.conect();
            stm = con.createStatement();
            stm.execute(sql);
            registered = true;
            out.println("You're already in.");
            stm.close();
            con.close();
        } catch (SQLException e) {
            registered = false;
            out.println("You're not in.");
            e.printStackTrace();
        }
        return registered;
   }
    //77assd
    public int giveDorsal (int IDUsser) {
       
       Statement stm = null;
       Connection con = null;
       
       //Random Dorsal Generator
       Random randomGenerador = new Random();
       int randomDorsal = randomGenerador.nextInt(300);
       out.println("Here's the Dorsal: " + randomDorsal);
       boolean i = true;
       //Looking for an existent Dorsal like this one.
       String sqlComprobarRandom = "SELECT FROM usuariomaraton WHERE Dorsal="+randomDorsal;
       String sql = "INSERT INTO usuariomaraton (Dorsal) values ())";
  
       try {
           con = conection.conect();
           stm = con.createStatement();
           while(i!=false){
             randomGenerador = new Random();
             randomDorsal = randomGenerador.nextInt(300);
             
           i = stm.execute(sqlComprobarRandom);
           
           }
          
           stm.close();
           con.close();
           
      } catch (SQLException e) {
           out.println("Error: Trying to give dorsal");
           e.printStackTrace();
      } 
      
       return randomDorsal;
    }
}
    
//    public void DesasignarDorsal (Usuario usuario) {
//}
//}
