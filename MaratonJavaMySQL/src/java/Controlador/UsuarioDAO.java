package Controlador;

import Hibernate.Hibernate;
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
        
        public boolean Register(){
        boolean regisAnswer = false;
        
         try{
            regisAnswer = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Film as film where film.filmId between '");//Tengo que tener algo que saque objetos al recibir datos.  
            session.save(q);
         }
         catch (Exception e){
             e.printStackTrace();
         }
        
         return regisAnswer;        
        }
        
        public void UnRegister(String nickname, String password){
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Usuario as ussers where usser.Nickname="+nickname+"' & usser.Password="+password+"'");
            session.saveOrUpdate(q);
        }
        
}