package Modelo;
// Generated 17-abr-2018 11:54:33 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuariomaraton generated by hbm2java
 */
@Entity
@Table(name="usuariomaraton"
    ,catalog="bbdd_g1"
)
public class Usuariomaraton  implements java.io.Serializable {


     private UsuariomaratonId id;
     private Maraton maraton;
     private Usuario usuario;
     private Integer tiempo;
     private Integer dorsal;

    public Usuariomaraton() {
    }

	
    public Usuariomaraton(UsuariomaratonId id, Maraton maraton, Usuario usuario) {
        this.id = id;
        this.maraton = maraton;
        this.usuario = usuario;
    }
    public Usuariomaraton(UsuariomaratonId id, Maraton maraton, Usuario usuario, Integer tiempo, Integer dorsal) {
       this.id = id;
       this.maraton = maraton;
       this.usuario = usuario;
       this.tiempo = tiempo;
       this.dorsal = dorsal;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idusuario", column=@Column(name="IDUsuario", nullable=false) ), 
        @AttributeOverride(name="idmaraton", column=@Column(name="IDMaraton", nullable=false) ) } )
    public UsuariomaratonId getId() {
        return this.id;
    }
    
    public void setId(UsuariomaratonId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDMaraton", nullable=false, insertable=false, updatable=false)
    public Maraton getMaraton() {
        return this.maraton;
    }
    
    public void setMaraton(Maraton maraton) {
        this.maraton = maraton;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDUsuario", nullable=false, insertable=false, updatable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="Tiempo")
    public Integer getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    
    @Column(name="Dorsal")
    public Integer getDorsal() {
        return this.dorsal;
    }
    
    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }




}


