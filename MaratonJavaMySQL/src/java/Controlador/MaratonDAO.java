/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import org.hibernate.Session;
import Modelo.Usuariomaraton;
import Modelo.UsuariomaratonId;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
    public class MaratonDAO {
       
        Session session = null;
        MaratonDAO runDAO = new MaratonDAO();
        Usuariomaraton ussmara = new Usuariomaraton ();
        
        //Método para entregar dorsal.
        public int GiveDorsal(){
            int dorsal = 0;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            
            try{
                Query ndorsal = session.createQuery("from Usuariomaraton as ussmarath select max(ussmarath.dorsal) & is not null");
                dorsal= (Integer)ndorsal.uniqueResult();
                dorsal += 1;               
                session.save(dorsal);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }
            
            return dorsal;
        }
        
        //Método para inscribirse.
        public boolean Inscribe(){
            boolean inscAnswer = false;
            UsuariomaratonId ussmaraid = null;
            try{
                inscAnswer = true;
                ussmaraid.getIdmaraton();
                ussmaraid.getIdusuario();
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                Usuariomaraton insc = new Usuariomaraton(ussmaraid, ussmara.getMaraton(), ussmara.getUsuario());
                session.save(insc);
                
            }catch (Exception e){
                e.printStackTrace();
                
            }return inscAnswer;
        }
        
        //Método para desIncsribirse de la maratón.
        public void Unscribe(int idusuario, int idmaraton){
             this.session = Hibernate.getSessionFactory().getCurrentSession();    
             Query unscrib = session.createQuery ("from Usuariomaraton as ussermarth "
                            + "where ussermarth.IDUsuario ='"+idusuario+"' & ussermarth.IDMaraton ='"+idmaraton+"'");
             Usuariomaraton insmara = (Usuariomaraton)unscrib.uniqueResult();
            session.delete(insmara);         
        }
}
