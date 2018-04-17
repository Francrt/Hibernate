/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import Modelo.Juez;
import Modelo.Maraton;
import Modelo.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author admin
 */
public class AdministradorDAO extends UsuarioDAO {

    Session session = null;
    Maraton run = new Maraton();
    Usuario master = new Usuario();
    
    
    public List ShowUsserList(){
        List<Usuario> Ussers = null;
            try{
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                org.hibernate.Transaction tx = session.beginTransaction();
                Query show = session.createQuery("from Usuario as usser where usser.Nickname is not null");
                Ussers = (List<Usuario>) show.list();
                session.save(Ussers);
                
            }catch (Exception e){
                e.printStackTrace();
            }return Ussers;
    }
    
    public List GetUsserData(int idusuario, String nickname, String password, String email){
        List<Usuario> Data = null;
        try{
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org. hibernate.Transaction tx = session.beginTransaction();
            Query getU = session.createQuery("from  Usuario as usser where usser.IDUsuario="+idusuario+"' "
                      + "or usser.Nickname="+nickname+"'"
                      + "or usser.Email="+email+"'");
            Data = (List<Usuario>) getU.list();
            session.saveOrUpdate(Data);
        }catch (Exception e){
            e.printStackTrace();
            
        }return Data;
    }
    
    public List ShowJudgeList(int idjuez){
        List<Juez> Judge = null;
        try{
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            Query jdg = session.createQuery("from Juez as judge where judge.IDJuez="+idjuez+"'");
            Judge = (List<Juez>) jdg.list();
            session.saveOrUpdate(Judge);            
        }catch (Exception e){
            e.printStackTrace();
        }return Judge;
    }
    
    public boolean CreateMarathon(Date fecha, Double longitud, String ubicacion, int idjuez){
        boolean newMarathon = false;
        
        try{
            newMarathon = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Maraton marathon = new Maraton(run.getFecha(), run.getLongitud(), run.getUbicacion() , run.getIdjuez());
            session.save(marathon);
            
        }catch(Exception e){
            e.printStackTrace();
            
        }return newMarathon;      
    }
    
    public List GetMarathonData(int idmaraton, Date fecha, Double longitud, String ubicacion, int idjuez){
        List<Maraton> Datamar = null;
        try{
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            Query dmar = session.createQuery("from Maraton as marathon where marathon.IDMaraton="+idmaraton+"'"
                       + "or marathon.Fecha="+fecha+"'"
                       + "or marathon.Longitud="+longitud+"'"
                       + "or marathon.Ubicacion="+ubicacion+"'"
                       + "or marathon.IDJuez="+idjuez+"'");    
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);            
        }catch (Exception e){
            e.printStackTrace();
        }return Datamar;
    }
    
    public boolean CreateJudge(){
        boolean newJ = false;
        //ñkyuf
        return newJ;
    }
    
    
    public void DeleteUsser(String nickname, String password){

            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Query dusser = session.createQuery("from Usuario as usser"
                         + "where usser.Nickname ='"+nickname+"' & usser.Password ='"+password+"'");
            session.delete(dusser);         

    }
    
    public void DeleteMarathon(int idmaraton){
 
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Query dmarth = session.createQuery("from Maraton as marathon"
                         + "where marathon.IDMaraton ='"+idmaraton+"'");
            session.delete(dmarth);              
    }
    
    public List ShowJudgeAvaiability(String disponibilidad){
        List<Juez> Avaiable = null;
        try{
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            Query jdav = session.createQuery("from Juez as judge where judge.Disponibilidad="+disponibilidad+"'");
            Avaiable = (List<Juez>) jdav.list();
            session.saveOrUpdate(Avaiable);            
        }catch (Exception e){
            e.printStackTrace();
        }return Avaiable;
        
    }
}

