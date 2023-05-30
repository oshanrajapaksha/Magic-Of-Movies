package Servlets;

import DatAcc.UserDatAcc;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jv.User;

@WebServlet("/loginServ")
public class loginServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userRole = 0;
        UserDatAcc data = new UserDatAcc();
        if(request.getParameter("login") != null){
            User user = new User();
            user.setEmail(request.getParameter("unamel"));
            user.setPassword(request.getParameter("passl"));
            userRole = data.checkUserRole(user);
            
            session.setAttribute("email", request.getParameter("unamel"));
            switch(userRole){
                case 1 : {
                    session.setAttribute("role", "User");
                    response.sendRedirect("index.jsp");
                    break;
                }
                case 2 : {
                    session.setAttribute("role", "Admin");
                    response.sendRedirect("index.jsp");
                    break;
                }
                default : {
                    session.setAttribute("login_stat", "Incorrect email or password");
                    response.sendRedirect("LoginRegis.jsp");
                }
            }
            
        }
        
    }

    
}
