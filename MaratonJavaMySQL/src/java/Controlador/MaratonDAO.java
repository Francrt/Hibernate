/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import org.hibernate.Session;
import Modelo.Usuariomaraton;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
    public class MaratonDAO {
       
        Session session = null;
        MaratonDAO runDAO = new MaratonDAO();
        Usuariomaraton ussmara = new Usuariomaraton ();
        
        public int GiveDorsal(){
            int dorsal = 0;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            
            try{
                Query ndorsal = session.createQuery("from Usuariomaraton as ussmarath select max(ussmarath.dorsal)");
                dorsal = (Integer)ndorsal.uniqueResult();              
                session.save(dorsal);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }
            
            return dorsal;
        }
        
        public boolean Inscribe(){
            boolean inscAnswer = false;
            
            try{
                inscAnswer = true;
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                Usuariomaraton insc = new Usuariomaraton(ussmara.getMaraton(), ussmara.getUsuario(), runDAO.GiveDorsal());
                session.save(insc);
                
            }catch (Exception e){
                e.printStackTrace();
                
            }return inscAnswer;
        }
        
        
        public void Unscribe(int idusuario, int idmaraton){
             this.session = Hibernate.getSessionFactory().getCurrentSession();    
             Query unscrib = session.createQuery ("from Usuariomaraton as ussermarth "
                            + "where ussermarth.IDUsuario ='"+idusuario+"' & ussermarth.IDMaraton ='"+idmaraton+"'");
            session.delete(unscrib);         
        }
}
