<%-- 
    Document   : index
    Created on : 06-abr-2018, 9:31:41
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Utilidades.ServletMar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.ConectaDB"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index-Pagina Principal</title>
    </head>
    <body>

          <h1>Consulta a base de datos</h1>
          <form action="SerlvetPrueba" method="post">
              <table>
                  <tr>
                      <td>Consultar  Usuario</td>
                  </tr>
                  <tr>
                      <td>Usuario:</td>
                      <td><input type="text" size="3" name="usuario"</td>
                  </tr>
                  <tr></tr>
                  <tr>
        <td colspan="2" align="center">
            <input type="submit" value="ConsultaID"></td>
</tr>
</table>
          </form>
           <form action="ServletRegistro" method="post">
              <table>
                  <tr>
                      <td>Agregar Persona</td>
                       <td><input type="text" size="3" name="NickName"</td>
                       <td><input type="text" size="3" name="Password"</td>
                       <td><input type="email" size="3" name="Email"</td>
                  </tr>
                  <tr>
                  </tr>
                  <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Registrar"></td>
</tr>
</table>
          </form>
          
              </form>
           <form action="ServletEliminar" method="post">
              <table>
                  <tr>
                      <td>Eliminar Persona</td>
                       <td><input type="text" size="3" name="usuario"</td>
                  </tr>
                  <tr>
                  </tr>
                  <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Eliminar"></td>
</tr>
</table>
          </form>
           </form>
           <form action="ServletListadoUsuarios" method="post">
              <table>
                  <tr>
                      <td>Lista Usuarios</td>
                    </tr>
                  <tr>
                  </tr>
                  <tr>
        <td colspan="2" align="center">
            <input type="submit" value="MostrarListaUsers"></td>
</tr>
</table>
           </form>
               
          <form action="ServletObtenerJueces" method="post">
              <table>
                  <tr>
                      <td>Crear Maraton </td>
                      
                  </tr>
                  <tr>
                  </tr>
                  <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Crear Maraton"></td>
</tr>
</table>
          </form>
    </body>
</html>
