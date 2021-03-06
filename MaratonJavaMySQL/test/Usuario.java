package Modelo;
// Generated 17-abr-2018 11:54:33 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="bbdd_g1"
)
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private String nickname;
     private String password;
     private String email;
     private Set usuariomaratons = new HashSet(0);
     private Set administradors = new HashSet(0);
     private Set juezs = new HashSet(0);

    public Usuario() {
    }
    
    public Usuario(String nickname, String password, String email){
       this.nickname = nickname;
       this.password = password;
       this.email = email;
    }

    public Usuario(String nickname, String password, String email, Set usuariomaratons, Set administradors, Set juezs) {
       this.nickname = nickname;
       this.password = password;
       this.email = email;
       this.usuariomaratons = usuariomaratons;
       this.administradors = administradors;
       this.juezs = juezs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDUsuario", unique=true, nullable=false)
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    
    @Column(name="Nickname", length=45)
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    
    @Column(name="Password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="Email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getUsuariomaratons() {
        return this.usuariomaratons;
    }
    
    public void setUsuariomaratons(Set usuariomaratons) {
        this.usuariomaratons = usuariomaratons;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="usuarioadmin", catalog="bbdd_g1", joinColumns = { 
        @JoinColumn(name="IDUsuario", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="IDAdmin", nullable=false, updatable=false) })
    public Set getAdministradors() {
        return this.administradors;
    }
    
    public void setAdministradors(Set administradors) {
        this.administradors = administradors;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
    public Set getJuezs() {
        return this.juezs;
    }
    
    public void setJuezs(Set juezs) {
        this.juezs = juezs;
    }




}


