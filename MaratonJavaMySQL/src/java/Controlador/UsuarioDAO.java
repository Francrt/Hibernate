package Controlador;


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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class UsuarioDAO {
    
    
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
       
    
    public static void main (String[] args){
        UsuarioDAO test = new UsuarioDAO();
        test.Unregister();
    }
}
