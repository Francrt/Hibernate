package Controlador;

import Hibernate.Hibernate;
import Modelo.Maraton;
import Modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author admin
 */
    public class UsuarioDAO implements InterfazBase {
        
        Session session = null;
        Usuario master = new Usuario();
        
        public boolean Register(){
        boolean regisAnswer = false;
        
         try{
            regisAnswer = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Usuario regis = new Usuario(master.getNickname(), master.getPassword(), master.getEmail());
            session.save(regis);
         }
         catch (Exception e){
             e.printStackTrace();
         }
        
         return regisAnswer;        
        }
        
        public void UnRegister(String nickname, String password){
            this.session = Hibernate.getSessionFactory().getCurrentSession();    
            Query unregis = session.createQuery ("Select Usuario "
                            + "from Usuario usser, Bar Nickname, Bar Password "
                            + "where usser.Nickname ='"+nickname+"' & usser.Password ='"+password+"'");
            session.delete(unregis);         
        }
        
        public boolean LogIn(String nickname, String password){
            boolean inAnswer = false;
            
                try{
                    inAnswer = true;
                    this.session = Hibernate.getSessionFactory().getCurrentSession();
                    Query login = session.createQuery ("From Usuario usser  "
                                + "where usser.Nickname ='"+nickname+"' & usser.Password ='"+password+"'");
                    if(login.getNickname().equals(nickname) &&
                       login.getPassword().equals(password){
                        
                    }
                    
                }catch (Exception e){
                    e.printStackTrace();
                }
            return inAnswer;
        }
        
        public void LogOut(){
            this.session = Hibernate.getSessionFactory().getCurrentSession();
        }
        
        public List ViewEnrollment(){
            List<Usuario> Enrollments = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();//get Entity by ID para hashmap
                
            }catch (Exception e){
                e.printStackTrace();
                
            }return Enrollments;           
        }
        
        public List ViewMarathon(){
            List<Maraton> Runs = null;
            try{
                org.hibernate.Transaction tx = session.beginTransaction();
                Query run = session.createQuery("from Maraton as run where run.fecha is not null");
                Runs = (List<Maraton>) run.list();
                
            }catch (Exception e){
                e.printStackTrace();
            }return Runs;
        }
        
        public boolean UpdateData(String password, String email){
            boolean update = false;            
            try{
                update = true;
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                Query up = session.createQuery ("From Usuario usser where"
                        + "usser.Password ='"+password+"' & usser.Email ='"+email+"'");
                
                
            }catch (Exception e){
                e.printStackTrace();
           
            }return update;
        }
}