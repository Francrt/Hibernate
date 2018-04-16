/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author admin
 */

//Conexion BBDD
public class ConectaDB {
    
    public static Connection conect(){
    
          Connection conect = null;
          
          try{
              Class.forName("com.mysql.jdbc.Driver");
              String servidor = "jdbc:mysql://192.168.203.4:3306/bbdd_g1"; //conectamos a nuestra propia maquina
              String usuario = "admin_g1";
              String password = "a7586";
              //inicializamos objeto conecta, del tipo connection
              conect = (Connection)DriverManager.getConnection(servidor, usuario, password);
              
          }catch(ClassNotFoundException e)
          {
              System.out.println(e.getMessage());
          }
            catch(Exception e) //capturar el resto de exceptions
          {
              System.out.println(e.getMessage());
          }finally{
              return conect;//como el default de los case, pero se ejecuta si o si
          }
    
    }    

    public PreparedStatement preparedStatement(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
