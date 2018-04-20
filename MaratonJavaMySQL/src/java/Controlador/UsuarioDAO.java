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
    public class UsuarioDAO {
        
        Session session = null;
        Usuario master = new Usuario();
        
        public boolean Register(){
        boolean regisAnswer = false;
        
         try{
            regisAnswer = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Usuario regis = new Usuario(master.getNickname(), master.getPassword(), master.getEmail(), master.getDNI(), master.getTelefono());
            session.save(regis);
            session.close();
         }
         catch (Exception e){
             e.printStackTrace();
         }
        
         return regisAnswer;        
        }
        
        public void UnRegister(String nickname, String password){
            this.session = Hibernate.getSessionFactory().getCurrentSession();    
            Query unregis = session.createQuery ("from Usuario as usser "
                            + "where usser.nickname ='"+nickname+"' & usser.password ='"+password+"'");
            session.delete(unregis);  
            session.close();
        }
        
        public boolean LogIn(String nickname, String password, String admin, String adminpass){
            boolean inAnswer = false;
            Usuario usser = null;
                try{
                    inAnswer = true;
                    this.session = Hibernate.getSessionFactory().getCurrentSession();
                    Query login = session.createQuery ("from Usuario as usser  "
                                + "where usser.nickname ='"+nickname+"' & usser.password ='"+password+"'");
                    usser = (Usuario)login.uniqueResult(); 
                    session.save(usser);
                    session.close();                                           
                }catch (Exception e){
                    e.printStackTrace();
                }
            return inAnswer;
        }
        
        public void LogOut(){
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            session.close();
        }
        
        public List ViewEnrollment(int idusuario){
            List<Maraton> Enrollments = null;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            
            try{             
                Query enrollment = session.createQuery("from Usuariomaraton get entity by '"+idusuario+"' where dorsal is not null");
                Enrollments = (List<Maraton>) enrollment.list();
                session.saveOrUpdate(Enrollments);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Enrollments;           
        }
        
        public List ViewMarathon(){
            List<Maraton> Runs = null;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
                
            try{
                Query run = session.createQuery("from Maraton as run where run.fecha is not null");
                Runs = (List<Maraton>) run.list();
                session.save(Runs);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Runs;
        }
        
        public boolean UpdateData(String password, String email){
            boolean update = false;            
            try{
                update = true;
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                Query up = session.createQuery ("from Usuario usser where"
                        + "usser.Password ='"+password+"' or usser.Email ='"+email+"'");
                session.saveOrUpdate(up);
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
           
            }return update;
        }
        
        public List ViewClasification(int idusuario){
             List<Usuario> Class = null;
             this.session = Hibernate.getSessionFactory().getCurrentSession();
             org.hibernate.Transaction tx = session.beginTransaction();
             
            try{
                Query clasification = session.createQuery("from Usuariomaraton get entity by '"+idusuario+"' where Tiempo is not null");
                Class = (List<Usuario>) clasification.list();
                session.saveOrUpdate(Class);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Class;
        }
}