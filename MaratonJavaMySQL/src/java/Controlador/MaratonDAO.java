/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import Modelo.Maraton;
import Modelo.Usuario;
import org.hibernate.Session;
import Modelo.Usuariomaraton;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
            Random random = new Random();
            int dorsal = random.nextInt(150);
            Integer dbdorsal;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            
            try{
                Query ndorsal = session.createQuery("from Usuariomaraton as ussmarath where ussmarath.dorsal is '"+dorsal+"'");
                dbdorsal = (Integer)ndorsal.uniqueResult();
                if(dbdorsal == dorsal){
                    ussmara.setDorsal(dorsal);
                }else return 0;
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
