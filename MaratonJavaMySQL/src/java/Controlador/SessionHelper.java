/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class SessionHelper {
    
    Session session = null;
    
    public SessionHelper(){
    this.session = Hibernate.getSessionFactory().getCurrentSession();
}
}
