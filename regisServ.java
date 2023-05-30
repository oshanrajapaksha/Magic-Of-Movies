package Servlets;

import DatAcc.UserDatAcc;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jv.User;


@WebServlet("/regisServ")
public class regisServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDatAcc uData = new UserDatAcc();
        int numRows = 0;
        HttpSession session = request.getSession();
        
        if(request.getParameter("regis") != null){
            
            User user = new User();
            String email = request.getParameter("emailregis");
            String fullName = request.getParameter("uname1")+" "+request.getParameter("uname2");
            user.setEmail(email);
            user.setName(fullName);
            user.setPassword(request.getParameter("passr"));
            user.setRole("User");
            user.setAddress("NA");
            user.setDob("NA");
            user.setProfPic("NA");
            user.setAdMsg("NA");
            
            numRows = uData.insertNewUser(user);
            
            if(numRows>0){
                session.setAttribute("RegisStats", "Welcome "+fullName+"!");
                response.sendRedirect("LoginRegis.jsp");
            }else{
                session.setAttribute("RegisStats", "Registration failed. Try again.");
                response.sendRedirect("LoginRegis.jsp");
            }
        }
    }
}
