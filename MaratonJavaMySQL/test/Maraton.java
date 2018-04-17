/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.JuezDAO;
import java.util.HashMap;
import Modelo.Usuario;
import java.util.Date;
import java.util.Map;




/**
 *
 * @author admin
 */
public class Maraton {
    
    //Se declaran los atributos
    private Date fecha;
    private int id;
    private double longitudRecorrido;
    private String ubicacion;
    
    Map<Usuario,String> participantes = new HashMap<Usuario, String>(); // en este map se incluirán los usuarios inscritos 
    Map<String,String> dorsalMarca = new HashMap<String, String>(); // en este map se relaciona un dorsal con un tiempo.

    //metodo constructor
    public Maraton(Date fecha, int id, double longitudRecorrido, String ubicacion) {
        this.fecha = fecha;
        this.id = id;
        this.longitudRecorrido = longitudRecorrido;
        this.ubicacion = ubicacion;
       
    }

    //A partir de aqui : Getters y Setters.
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setParticipantes(Map<Usuario, String> participantes) {
        this.participantes = participantes;
    }

    public void setDorsalMarca(Map<String, String> dorsalMarca) {
        this.dorsalMarca = dorsalMarca;
    }

    
    
    public Date getFecha() {
        return fecha;
    }

    public Map<Usuario, String> getParticipantes() {
        return participantes;
    }

    public Map<String, String> getDorsalMarca() {
        return dorsalMarca;
    }

  
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitudRecorrido() {
        return longitudRecorrido;
    }

    public void setLongitudRecorrido(double longitudRecorrido) {
        this.longitudRecorrido = longitudRecorrido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

  
    
    

  
    
  
  
    
    
}
