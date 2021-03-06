package Modelo;
// Generated 17-abr-2018 11:54:33 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsuariomaratonId generated by hbm2java
 */
@Embeddable
public class UsuariomaratonId  implements java.io.Serializable {


     private int idusuario;
     private int idmaraton;

    public UsuariomaratonId() {
    }

    public UsuariomaratonId(int idusuario, int idmaraton) {
       this.idusuario = idusuario;
       this.idmaraton = idmaraton;
    }
   


    @Column(name="IDUsuario", nullable=false)
    public int getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }


    @Column(name="IDMaraton", nullable=false)
    public int getIdmaraton() {
        return this.idmaraton;
    }
    
    public void setIdmaraton(int idmaraton) {
        this.idmaraton = idmaraton;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuariomaratonId) ) return false;
		 UsuariomaratonId castOther = ( UsuariomaratonId ) other; 
         
		 return (this.getIdusuario()==castOther.getIdusuario())
 && (this.getIdmaraton()==castOther.getIdmaraton());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdusuario();
         result = 37 * result + this.getIdmaraton();
         return result;
   }   


}


