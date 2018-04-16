/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author admin
 */
public class Métodos {

    // ADMIN \\
    
    
import Modelo.ConectaDB;
import Modelo.Usuario;
import Modelo.Maraton;
import Modelo.Juez;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

    
      private ConectaDB conection;
      ArrayList<Usuario> Ussers;
      ArrayList<Juez> Judges;
      ArrayList<Maraton> Marathon;
     /**
     * 
     * USUARIOS
     * 
     */
      
       //Mediante la insercion de determinados datos, sera agregado a la base de datos un usuario
       public boolean AñadirUsuario(Usuario Usser) {
        boolean answer=false;
        Statement stm = null;
        Connection con =
                null;
        String sql = "INSERT INTO usuario(Nickname,Password, Email) values ('" +Usser.getNickName() + "','" + Usser.getPassword() + "','" + Usser.getEmail() + "')";
        try {
            con = conection.conect();
            stm = con.createStatement();
            stm.execute(sql);
            answer = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            answer = false;
          
            out.println("Error:método registrar");
            e.printStackTrace();
        }
        return answer;
    }

      public ArrayList<Usuario> getUsuarios(){
          int id;
          String nickName;
          String password;
          String Email;
          Connection con = null;
          con = conection.conect();
          ArrayList<Usuario> Usuarios = new ArrayList();                    
          ResultSet data;
          
          try{
          PreparedStatement getData = con.prepareStatement("SELECT IDUsuario, Nickname, Password, Email FROM usuario");                        
          data = getData.executeQuery();
          while(data.next()){
            id = data.getInt(1);
            nickName = data.getString(2);
            password = data.getString(3);
            Email = data.getString(4);
          Usuario usser = new Usuario(data.getInt(1), data.getString(2), data.getString(3), data.getString(4));
          Usuarios.add(usser);
          }
           return Usuarios;
      } catch(SQLException e){
           e.printStackTrace();
        }  return Usuarios;
    } 
    
    //Eliminar un usuario mediante la introduccion de su respectiva ID
     public  boolean  deleteID(int ID){
        boolean deleteAnswer=false;
       
        Connection con = conection.conect();
        Usuario Ps=null;
        Statement stm;
  
        // Creamos la sentencia SQL
        String sql = "DELETE FROM usuario WHERE IDUsuario="+ID;
        // Ejecutamos la sentencia SQL
        try {   
            // Mostramos los datos de los registros
             stm = con.createStatement();
             stm.executeUpdate(sql);
             deleteAnswer = true;

            // Cerramos las conexiones
            
            stm.close();
            con.close();
        } catch (SQLException e) {
             deleteAnswer = false;
               e.printStackTrace();
        }
        return deleteAnswer;
        
        
    }
    
     //Realizar una busqueda/consulta de informacion a traves del id de su respectivo usuario
     public Usuario WatchID(int ID){
        Connection con = conection.conect();
        Usuario Ps = null;
        Statement st;
        ResultSet rs;
        // Creamos la sentencia SQL
        String sql = "SELECT * FROM usuario where IDUsuario="+ID+"";
        // Ejecutamos la sentencia SQL
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            // Mostramos los datos de los registros
            while (rs.next()) {
             Ps = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
            }
          
            // Cerramos las conexiones
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ps;
        
        
    }
     
    /**
     * 
     * MARATON
     * 
     */
     
     
     //Metodo que nos devuelve los jueces disponibles
     public ArrayList<Usuario> LeerJuez(){
        
        Connection con = conection.conect();
        ArrayList<Usuario> Ps = new ArrayList<>();
        Statement st;
        ResultSet rs;
        String flag="TRUE";
        // Creamos la sentencia SQL
         String sql = "SELECT usuariojuez.IDJuez, usuario.Nickname, usuario.Password, usuario.Email FROM usuario INNER JOIN usuariojuez ON usuario.IDUsuario= usuariojuez.IDUsuario INNER JOIN juez ON Disponibilidad = '"+flag+"'";         
    
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            // Vamos recorriendo la consulta y añadiendo cada usuario al ArrayList que luego se devolvera para obtener los usuarios
            while (rs.next()) {
             
                Ps.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
          
            // Cerramos las conexiones
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ps;   
    }
     
     
     
    
      //Mediante la insercion de determinados datos, se crearala maraton y se le asignara un juez
     /*  public boolean CrearMaraton(Maraton maraton) {
        boolean rptaRegistro=false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO maraton(Longitud,Ubicacion, IDJuez) values ('" +maraton + "','" + maraton + "','" + maraton + "')";
        try {
            con = conexion.conecta();
            stm = con.createStatement();
            stm.execute(sql);
            rptaRegistro = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            rptaRegistro = false;
          
            out.println("Error:método registrar");
            e.printStackTrace();
        }
        return rptaRegistro;
    }*/
    
       // MARATON \\         

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
 
     
     
     MaratonDAO {
    
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


                // USUARIO \\

import Modelo.ConectaDB;
import Modelo.Usuario;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;


    
        ArrayList<Usuario> Ussers;
        private ConectaDB conection;

        public boolean Register(Usuario usser) {
        boolean answerRegister=false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO usuario(Nickname,Password, Email) values ('" +usser.getNickName() + "','" + usser.getPassword() + "','" + usser.getEmail() + "')";
        try {
            con = conection.conect();
            stm = con.createStatement();
            stm.execute(sql);
            answerRegister = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            answerRegister = false;
          
            out.println("Error:método registrar");
            e.printStackTrace();
        }
        return answerRegister;
    }
       
    public void Unregister()  {
        
        Ussers.get(1);
        System.out.println(Ussers.get(1));
    }
}

//

}
   
