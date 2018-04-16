<%-- 
    Document   : mostrar.jsp
    Created on : 08-abr-2018, 21:22:21
    Author     : admin
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controlador.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table border="1">
        <tr>
            <td>ID</td>
            <td>NOMBRE</td>
            <td>PASSWORD</td>
            <td>E-MAIL</td>
            
            </tr>
           <%
            Usuario CP= (Usuario)request.getAttribute("pers");
                    out.println("<tr>");
                    out.println("<td>"+CP.getId()+"</td>");
                    out.println("<td>"+CP.getNickName()+"</td>");
                    out.println("<td>"+CP.getPassword()+"</td>");
                    out.println("<td>"+CP.getEmail()+"</td>");
                    out.println("</tr>");
            
           %>
     
          </table>  
            
            
            
        
        
        
        
        
        
    </body>
</html>
