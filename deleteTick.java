
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

/**
 *
 * @author user
 */
@WebServlet("/deleteTick")
public class deleteTick extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        if(req.getParameter("tid") != null){
            Ticket tick1 = new Ticket();
            TickDataAcc data = new TickDataAcc();
            tick1.setId(Integer.parseInt(req.getParameter("tid")));
            
            if(data.deleteTicketRecord(tick1) > 0){
                resp.sendRedirect("uBoard.jsp");
                
            }
            
        }
    }

}
