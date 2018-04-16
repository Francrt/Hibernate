                        //Metodos sin Identificar\\


                        //Registrar\\
    /* public boolean Registrar(Usuario usser) {
       * boolean answer = false;
        *Statement stm = null;
        *Connection con = null;
        *String sql = "INSERT INTO usuario(Nickname,Password, Email) values ('" +usser.getNickName() + "','" + usser.getPassword() + "','" + usser.getEmail() + "')";
        *try {
            *con = conexion.conecta();
            *stm = con.createStatement();
            *stm.execute(sql);
            *answer = true;
            *stm.close();
            *con.close();
        } *catch (SQLException e) {
            *answer = false;
          
            *out.println("Error: NO ha sido posible realizar el registro.");
            *e.printStackTrace();
        }
        *return answer;
    }*/
         

                    //UnRegister\\
    /*  public boolean UnRegister(Usuario usser) {
       * boolean answer = false;
        *Statement stm = null;
        *Connection con = null;
        *String sql = "DELETE FROM usuario PARTITION (Nickname,Password, Email)";
        *try {
            *con = conexion.conecta();
            *stm = con.createStatement();
            *stm.execute(sql);
            *answer = true;
            *stm.close();
            *con.close();
        } *catch (SQLException e) {
            *answer = false;
          
            *out.println("Error: No ha sido posible eliminar su registro.");
            *e.printStackTrace();
        }
        *return answer;
    }*/


                        //LogIn\\
    /*(Not Working) * private void LogIn(String Nickname, String Password){
       * String captura ="";
        
        *String sql = " SELECT * FROM usuario WHERE Nickname = '" +Nickname+ "'& Password = '" +Password+ "' ";
        *try...*/
       

                        //Inscribir\\
    /* private boolean Inscribir(Usuario usser, Maraton run, MaratonDAO dorsal){
       * boolean answer = false;
        *Statement stm = null;
        *Connection con = null;
        *String sql = "INSERT INTO usuariomaraton (IDUsuario, IDMaraton, Dorsal) values ('" +usser.getId() + "','" +run.getId() + "','" + dorsal.AsignarDorsal() + "')";
        *try {
            *con = conexion.conecta();
            *stm = con.createStatement();
            *stm.execute(sql);
            *answer = true;
            *stm.close();
            *con.close();
        }* catch (SQLException e) {
            *answer = false;
          
            *out.println("Error: Su solicitud no ha podido ser procesada");
            *e.printStackTrace();
        }
        *return answer;
    }*/   
    

                //Unscribe\\
    /*  private boolean UnInscribe(int ID ){
       * boolean answer = false;
        *Statement stm = null;
        *Connection con = null;
        *String sql = "DELETE FROM usuariomaraton  WHERE IDUsuario="+id;
" ;
        *try {
            *con = conexion.conecta();
            *stm = con.createStatement();
            *stm.execute(sql);
            *answer = true;
            *stm.close();
            *con.close();
        }* catch (SQLException e) {
            *answer = false;
          
            *out.println("Error: Su solicitud no ha podido ser procesada");
            *e.printStackTrace();
        }
        *return answer;
    }*/   
    

                     //Consulta\\
    /*  public boolean ConsultaInscripcion(int id){
       * Connection con = conexion.conecta();
        *boolean inscrito = false;
        *Statement stm;
        *ResultSet rs;
        // Creamos la sentencia SQL
        *String sql = "SELECT * FROM usuariomaraton WHERE IDUsuario="+id+"";
        // Ejecutamos la sentencia SQL
        
        *try {
            *con = conexion.conecta();
            *stm = con.createStatement();
            *stm.execute(sql);
            *if (inscrito = true){
                *out.println("¡Ya estas inscrito!");
                *out.print("Este es tu dorsal: ");
                *out.println();
            }
            *stm.close();
            *con.close();
        } *catch (SQLException e) {
            *inscrito = false;
            *out.println("Usuario no inscrito");
            *e.printStackTrace();
        }
        *return inscrito;
   }*/
    

            //VerMaratones\\
    /*  public void VerMaratones(){
        *Statement stm = null;
        *Connection con = null;
        
        *String sql = "SELECT * FROM maraton";
      */

    /*public void ModificarDatos(int ID){
        Connection con = conexion.conecta();
        Statement stm;
        ResultSet rs;
        // Creamos la sentencia SQL
        String sql = "UPDATE contacto SET ID=?, Nickname=?, Password=?, Email=?" + "WHERE id_contacto=?";

        try {       
        PreparedStatement prest = conexion.prepareStatement(sql);   
        prest.PreparedStatement(1, nombre); //Ejemplo

        // Ejecutamos la sentencia SQL
            con = conexion.conecta();
            stm = con.createStatement();
            stm.execute(sql);
            stm.close();
            con.close();
        } catch (SQLException e) {
            inscrito = false;
            out.println("Usuario no inscrito");
            e.printStackTrace();
        }
        return inscrito;
    }
}*/

