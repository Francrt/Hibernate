package Controlador;

import Hibernate.Hibernate;
import Modelo.Maraton;
import Modelo.Usuario;
import Modelo.Usuariomaraton;
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
        
        //Método para registrar usuarios
        public boolean Register(){
        boolean regisAnswer = false;
        
         try{
            regisAnswer = true;
            this.session = Hibernate.getSessionFactory().getCurrentSession();//iniciamos la session
            Usuario regis = new Usuario(master.getNickname(), master.getPassword(), master.getEmail(), master.getTelefono(), master.getDni(), master.getJuez());
            //Obtenemos los datos del  nuevo usuario
            session.save(regis);//Guardamos el objeto creado.
            session.close();//Cerramos la session
         }
         catch (Exception e){
             e.printStackTrace();
         }
        
         return regisAnswer;        
        }
        
        //Método para eliminar el registro de un usuario.
        public void UnRegister(String nickname, String password){
            Usuario deleteregs;
            this.session = Hibernate.getSessionFactory().getCurrentSession();    
            Query unregis = session.createQuery ("from Usuario as usser "//Extraemos de la db el objeto que concuerca con el nickname y el pass aportado para eliminar el registro.
                            + "where usser.nickname ='"+nickname+"' & usser.password ='"+password+"'");
            deleteregs = (Usuario)unregis.uniqueResult(); //Guardamos el objeto como Usuario
            session.delete(deleteregs);//Eliminamos el registro  
            session.close();
        }
        
        //Método LogIn
        public Usuario LogIn(String nickname, String password){
            Usuario usser = null;//Inicializo un usser.
                try{
                    this.session = Hibernate.getSessionFactory().getCurrentSession();
                    Query login = session.createQuery ("from Usuario as usser  " 
                                + "where usser.nickname ='"+nickname+"' & usser.password ='"+password+"'");
                    //Se comprueba que el nickname y el password aportado concuerda con uno ya existente en db.
                    usser = (Usuario)login.uniqueResult(); 
                    session.close();                                           
                }catch (Exception e){
                    e.printStackTrace();
                }
            return usser;
        }
        
        //Método LogOut
        public void LogOut(){
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            session.close();
        }
        
        //Método para ver la lista de maratones en los que participas.
        public List ViewEnrollment(int idusuario){
            List<Maraton> Enrollments = null;//Instanciamos la lista de Maratones.
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();//Iniciamos la sessión y comenzamos la transacción.
            
            try{             
                Query enrollment = session.createQuery("from Usuariomaraton get entity by '"+idusuario+"' "
                                 + "where dorsal is not null");
                //Buscamos todos los objetos que coincidan con un usuario en el que su dorsal no sea nula.
                Enrollments = (List<Maraton>) enrollment.list();//Guardamos los objetos en una lista.
                session.saveOrUpdate(Enrollments);//Guardamos o Actualizamos la session
                tx.commit();//Acometemos la transacción
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();//En caso de que falle se devuelve la transacción al inicio del programa.
            }return Enrollments;           
        }
        
        //Método para ver todos los maratones.
        public List ViewMarathon(){
            List<Maraton> Runs = null;//Instanciamos una lista de maratones.
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
                
            try{
                Query run = session.createQuery("from Maraton as run where run.fecha is not null");
                //Buscamos todos los maratones que tengan una fecha != null.
                Runs = (List<Maraton>) run.list(); //Guardamos los objetos en la lista.
                session.saveOrUpdate(Runs);//Guardamos o Actualizamos.
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Runs;
        }
        
        //Método para modificar los datos de un usuario.
        public boolean UpdateData(String password, String email){
            boolean update = false;   
            Usuario modify;
            try{
                update = true;
                this.session = Hibernate.getSessionFactory().getCurrentSession();
                Query up = session.createQuery ("from Usuario usser where"
                         + "usser.password ='"+password+"' && usser.email='"+email+"'");
                //Buscamos un usuario coincidente coincidente con el email y el pass
                modify = (Usuario)up.uniqueResult();//Guardamos el objeto.
                modify.getPassword();
                modify.getEmail();
                //Solicitamos la Password nueva or el Email nuevo.
                session.saveOrUpdate(modify);
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
           
            }return update;
        }
        
        //Método para ver los tiempos del usuario.
        public List ViewPersonalTimes(int idusuario){
             List<Usuario> Times = null;
             this.session = Hibernate.getSessionFactory().getCurrentSession();
             org.hibernate.Transaction tx = session.beginTransaction();
             
            try{
                Query alltimes = session.createQuery("from Usuariomaraton get entity by '"+idusuario+"' where tiempo is not null");
                //Buscamos en la tabla aquel objeto que tenga idusuario y que su tiempo no sea nulo, así podríamos llegar a extraer todos sus tiempos.
                Times = (List<Usuario>) alltimes.list();
                session.saveOrUpdate(Times);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();
            }return Times;
        }
        
        //Método para conseguir las clasificaciones ordenadas.
        public List ViewClasification(){
            List<Usuariomaraton> Class = null;
            this.session = Hibernate.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            
            try{
                Query clasglob = session.createQuery("from Usuariomaraton as ussmarath  order by tiempo");
                Class = (List<Usuariomaraton>) clasglob.uniqueResult();
                session.saveOrUpdate(Class);
                tx.commit();
                session.close();
                
            }catch (Exception e){
                e.printStackTrace();
                tx.rollback();              
            }return Class;      
    }
}