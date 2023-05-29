
package Servlets;

import DatAcc.TickDataAcc;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jv.Ticket;

@WebServlet("/bookingServ")
public class bookingServ extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Ticket tick = new Ticket();
        TickDataAcc book = new TickDataAcc();
        int numRows;
        
        if(session.getAttribute("email") != null && req.getParameter("Book") != null){
        
        tick.setEmail(String.valueOf(session.getAttribute("email")));
        tick.setMid(Integer.parseInt(req.getParameter("mId")));
        tick.setNoTicket(Integer.parseInt(req.getParameter("nTick")));
        
        int noTicket;
        noTicket = Integer.parseInt(req.getParameter("nTick"));
        Double tPrice = Double.valueOf(req.getParameter("mPrice"));
        
        Double total = noTicket*tPrice;
        out.println(total);
        tick.setTotal(total);
        
        numRows = book.insertTicket(tick);
        if(numRows>0){
            session.setAttribute("book_stat", String.valueOf(noTicket)+" tickets booked for "+String.valueOf(req.getParameter("mName"))+" successfully.");
            resp.sendRedirect("moviesAll.jsp");
        }else{
            session.setAttribute("book_stat", "Booking ticket failed.");
            resp.sendRedirect("LoginRegis.jsp");
        }
        
        }else{
            resp.sendRedirect("LoginRegis.jsp");
        }
        
    }

}
