<%-- 
    Document   : index
    Created on : 06-abr-2018, 9:31:41
    Author     : admin
--%>

<%@page import="Controlador.UsuarioDAO"%>
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
        <title>JSP Listado</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!-- no hacerlo, es una barbaridad, seria lo mismo hacerlo con println -->
          <h1>Consulta a base de datos</h1>
          <%if(ConectaDB.conecta()!=null){%>
          <h1> conectando</h1>
          <%
          }else{
          %>
          <h1> no conecta </h1>
          <%}%>
          
                 <table border="1">
        <tr>
            <td>ID</td>
            <td>NOMBRE</td>
            <td>PASSWORD</td>
            <td>E-MAIL</td>
            
            </tr>
           <%
            
            ArrayList<Usuario> Ps = (ArrayList<Usuario>)request.getAttribute("List");
            for (int i=0;i<Ps.size();i++)
                {
                    out.println("<tr>");
                    out.println("<td>"+Ps.get(i).getId()+"</td>");
                    out.println("<td>"+Ps.get(i).getNickName()+"</td>");
                    out.println("<td>"+Ps.get(i).getPassword()+"</td>");
                    out.println("<td>"+Ps.get(i).getEmail()+"</td>");
                    out.println("</tr>");
                }
           %>
</table>
        
     
        
    </body>
</html>
