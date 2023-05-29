package Servlets;

import DatAcc.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/adminMsg")
public class adminMsg extends HttpServlet {
    
    private final Connection databaseConnection;
	public adminMsg() {
            this.databaseConnection = new ConnectionProvider().getMySQLConnection();
        }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        String sql1 = "UPDATE `users` SET `messege` = ? WHERE `users`.`role` = ?;";
        HttpSession session = req.getSession();
        int numRows = 0;
        try {
            PreparedStatement p = databaseConnection.prepareStatement(sql1);
            
            if((req.getParameter("email") != "") && (session.getAttribute("role")=="User")){
                String uEmail = req.getParameter("email");
                p.setString(1, uEmail);
                p.setString(2, "Admin");
                numRows = p.executeUpdate();
                
                
                if(numRows>0){
                    session.setAttribute("MsgStat","Your request to be an administrator is sent to the website administrators.");
                    resp.sendRedirect("uBoard.jsp");
                }else{
                    session.setAttribute("MsgStat", "Something Went Wrong...");
                    resp.sendRedirect("LoginRegis.jsp");
                }
            }else{
                resp.sendRedirect("LoginRegis.jsp");
            } 
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }      
    }


}
