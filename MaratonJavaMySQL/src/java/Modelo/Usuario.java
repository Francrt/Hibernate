/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author admin
 */


public class Usuario {
    
    private int id;
    private String nickName;
    private String password;    
    private String Email; 

    
    public Usuario(int id, String nickName, String password, String Email) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.Email= Email;
    }
        
    
    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return Email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
