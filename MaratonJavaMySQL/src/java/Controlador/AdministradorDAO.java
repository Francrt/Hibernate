/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import Modelo.Maraton;
import Modelo.Usuario;
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
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
            try{
                Query show = session.createQuery("from Usuario as usser where usser.Nickname is not null");
                Ussers = (List<Usuario>) show.list();
                session.save(Ussers);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Ussers;
    }
    
    public List GetUsserData(int idusuario){
        List<Usuario> Data = null;
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org. hibernate.Transaction tx = session.beginTransaction();
        
        try{  
            Query getU = session.createQuery("from  Usuario as usser where usser.IDUsuario="+idusuario+"'");
            Data = (List<Usuario>) getU.list();
            session.saveOrUpdate(Data);
            tx.commit();
            session.close();
            
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            
        }return Data;
    }
    
    
    public List GetUsserData(String nickname, String password, String email, String telefono, String dni){
        List<Usuario> Data = null;
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx= session.beginTransaction();
        
        try{
            if (nickname != null && password == null && email == null && telefono == null && dni == null){
                Query getU = session.createQuery("from  Usuario as usser where usser.nickname="+nickname+"'");  
                Data = (List<Usuario>) getU.list();
                session.saveOrUpdate(Data);
                tx.commit();
                session.close();}
            
            else if (password != null && nickname == null && email == null && telefono == null && dni == null){
                Query getU = session.createQuery("from  Usuario as usser where usser.password="+password+"'");
                Data = (List<Usuario>) getU.list();
                session.saveOrUpdate(Data);
                tx.commit();    
                session.close();}  
            
            else if (email != null && password == null && email == null && telefono == null && dni == null){
                Query getU = session.createQuery("from  Usuario as usser where usser.email="+email+"'");
                Data = (List<Usuario>) getU.list();
                session.saveOrUpdate(Data);
                tx.commit();   
                session.close();}
            
            else if (telefono != null && password == null && email == null && nickname == null && dni == null){
                Query getU = session.createQuery("from  Usuario as usser where usser.telefono="+telefono+"'");
                Data = (List<Usuario>) getU.list();
                session.saveOrUpdate(Data);
                tx.commit();   
                session.close();}
            
            else if (dni != null && password == null && email == null && telefono == null && nickname == null){
                Query getU = session.createQuery("from  Usuario as usser where usser.dni="+dni+"'");
                Data = (List<Usuario>) getU.list();
                session.saveOrUpdate(Data);
                tx.commit();    
                session.close();}
            else return Data;

        }catch (Exception e){
            e.printStackTrace();
        }return Data;
    }
    
    public List ShowJudgeList(){
        List<Usuario> Judge = null;
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx= session.beginTransaction();
        
        try{         
            Query jdg = session.createQuery("from Usuario as judge where judge.juez is 1");
            Judge = (List<Usuario>) jdg.list();
            session.saveOrUpdate(Judge);
            tx.commit();
            session.close();
            
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }return Judge;
    }
    
    public boolean CreateMarathon(String fecha, Double longitud, String ubicacion, int idjuez){
        boolean newMarathon = false;
        
        try{
            newMarathon = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Maraton marathon = new Maraton(run.getNombre(), run.getFecha(), run.getLongitud(), run.getUbicacion());
            session.save(marathon);
            
        }catch(Exception e){
            e.printStackTrace();
            
        }return newMarathon;      
    }
    
    public List GetMarathonData(Integer idmaraton, Integer idusuario){
        List<Maraton> Datamar = null;
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx= session.beginTransaction();
        
        try{
            if (idmaraton != null && idusuario == null){
            Query dmar = session.createQuery("from Maraton as marathon where marathon.idmaraton='"+idmaraton+"'");  
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();
            session.close();}
            
        else if (idusuario != null && idmaraton == null){
            Query dmar = session.createQuery("from Maraton as marathon where marathon.idusuario='"+idusuario+"'");
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();   
            session.close();}
            
        }catch (Exception e){
            e.printStackTrace();
        }return Datamar;
    }
    
    public List GetMarathonData(String  nombre, String fecha, String ubicacion){
        List<Maraton> Datamar = null;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
        try{
            if(fecha != null && ubicacion == null && nombre == null){
            Query dmar = session.createQuery("from Maraton as marathon where marathon.fecha="+fecha+"'");   
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();
            session.close();}
            
            else if (ubicacion != null && fecha == null && nombre == null){
            Query dmar = session.createQuery("from Maraton as marathon where marathon.ubicacion="+ubicacion+"'");   
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();   
            session.close();}
            
            else if (nombre != null && fecha == null && ubicacion == null){
            Query dmar = session.createQuery("from Maraton as marathon where marathon.nombre="+nombre+"'");   
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();   
            session.close();}
        
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }return Datamar;
    }
    
    public List GetMarathonData(Double longitud){
        List<Maraton> Datamar = null;
        try{
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx= session.beginTransaction();
            Query dmar = session.createQuery("from Maraton as marathon where marathon.longitud="+longitud+"'");  
            Datamar = (List<Maraton>) dmar.list();
            session.saveOrUpdate(Datamar);
            tx.commit();
            session.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }return Datamar;
    }

    
    public boolean CreateJudge(){
        boolean newJ = false;
        
        try{
            newJ = true;
            Byte juez = 1;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Usuario newJudge = new Usuario(master.getDni(), master.getTelefono(), master.getNickname(), master.getPassword(), master.getEmail(), master.getAdmin(), juez);
            session.save(newJudge);
            session.close();
            
        }catch (Exception e){ 
            e.printStackTrace();
        }     
        return newJ;
    }
    
    public boolean UpdateToJudge(int nickname){
        boolean upUj = false;       
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        try{
            upUj = true;
            Usuario improve;
            Query update = session.createQuery("from Usuario as usser where usser.nickname='"+nickname+"'");
            improve = (Usuario)update.uniqueResult();
            improve.setJuez((byte) 1);
            session.saveOrUpdate(improve);
            tx.commit();
            session.close();
            
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        return upUj;
    }
    
    
    public void DeleteUsser(String nickname, String password){

            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Query dusser = session.createQuery("from Usuario as usser"
                         + "where usser.Nickname ='"+nickname+"' & usser.Password ='"+password+"'");
            session.delete(dusser);
            session.close();

    }
    
    public void DeleteMarathon(int idmaraton){
 
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            Query dmarth = session.createQuery("from Maraton as marathon"
                         + "where marathon.IDMaraton ='"+idmaraton+"'");
            session.delete(dmarth);  
            session.close();
    }
    
    public List ShowJudgeAvaiability(int idusuario){
        List<Usuario> Avaiable = null;
        this.session = Hibernate.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx= session.beginTransaction();
        
        try{         
            Query jdav = session.createQuery("from Usuario as judge where judge.juez is 1 && is not in Juezmaraton");
            Avaiable = (List<Usuario>) jdav.list();
            session.saveOrUpdate(Avaiable);
            tx.commit();
            session.close();   
            
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }return Avaiable;
        
    }
}

