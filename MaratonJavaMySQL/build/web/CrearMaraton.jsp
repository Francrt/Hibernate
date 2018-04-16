<%-- 
    Document   : CrearMaraton
    Created on : 10-abr-2018, 11:32:45
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Juez"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.ConectaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CrearMaraton.jsp</title>
    </head>
    <body>
       </table>

          </form>
           <form action="ServletCrearMaraton" method="post">
              <table> 
                  <tr> 
                      <td><h1>Crear Maraton<h1></td>
                 </tr>
                 <tr>
                       <td>Fecha: <input type="Date" name="Fecha" min="1" max="500"> </td>
                 </tr>
                 <tr>
                       <td>Longitud: <input type="number" name="LongitudRecorrido" min="1" max="500"  </td>
                 </tr>
                 <tr>    
                       <td>Ubicación: <input type="text" size="7" name="Ubicacion"</td>
                 </tr> 
                 <tr>
                     <td> Jueces 
                                   <%
                    ArrayList<Usuario> Ps = (ArrayList<Usuario>)request.getAttribute("ListJuez");  
                         %>
                         
                         <Select name="jueces">
                               <% 
                                   for(Usuario U:Ps){%>
                               {
                               <option value=="<%=U.getId() %>"> <%=U.getNickName()%> </option>
                                  <% 
                               }
                                   
                             %>
                         </select>
                     </td>
                     
              </tr>              
                  </tr>
                  <tr>
                  </tr>
                  <tr>
                   </tr>
                    <tr>
                  </tr>
        <td colspan="2" align="center">
            <input type="submit" value="Registrar"></td>
                <td colspan="2" align="center">
                    <input type="reset"></td>
</tr>
</table>
          </form>
          
          
    </body>

</html>
