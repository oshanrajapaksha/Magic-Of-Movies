<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="DatAcc.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <table class="table table-hover table-bordered table-dark table-sm mx-auto">
  <thead>
  <style>table thead th{
      color: darkgoldenrod;
      }
  </style>
    <tr>
      <th scope="col">User Email</th>
      <th scope="col">Option</th>
    </tr>
  </thead>
  <tbody>
                <%
        ConnectionProvider conn = new ConnectionProvider();
        Connection con = conn.getMySQLConnection();
        String sql = "SELECT `messege` FROM `users` WHERE `users`.`email` = ?;";
        String Aemail = String.valueOf(session.getAttribute("email"));
        
    try {
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, Aemail);
        ResultSet n = p.executeQuery();
        if(n.next())
        {%>
          
    <tr>
        <th scope="row"><%=n.getString("messege") %></th>
        <td><a href="makeAdmin.jsp?eUmail=<%=n.getString("messege") %>" class="badge badge-success">Make an ADMIN</a>
          <a href="deleteReq.jsp?eUmail=<%=n.getString("messege") %>" class="badge badge-danger">Delete</a></td>
    </tr><%   
        }
        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
		%>
    
  </tbody>
</table>
    </body>
</html>
