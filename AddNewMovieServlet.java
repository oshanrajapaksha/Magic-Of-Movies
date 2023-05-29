package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import jv.Movies;
import jv.Admin;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;

@MultipartConfig
@WebServlet("/AddNewMovieU")
public class AddNewMovieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        Movies movie1 = new Movies();
        Admin admin1 = new Admin();
        
        

        if(request.getParameter("addMovie") != null) {
                //Populates a Flight object with explicit POST data.
                LocalDate currDate = LocalDate.now();
                
                Part file = request.getPart("thumb");
                String imageName = file.getSubmittedFileName();
                String imagePath = "C:/Users/user/Desktop/New folder (3)/WebApplication1/web/Thumbs/"+imageName;
                
                try{
                    FileOutputStream fos = new FileOutputStream(imagePath);
                    InputStream is = file.getInputStream();
                
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
                    fos.close();
                }catch(IOException e){
                       System.out.println(e.getMessage());
                }
                
                //setting values to the movie1 object from AddMovieForm JSP page
                
                movie1.setName(request.getParameter("Mname"));
                movie1.setExpire_time(String.valueOf(request.getParameter("ExDate")));
                movie1.setTime_inserted(String.valueOf(currDate));
                movie1.setTicket_price(Double.parseDouble(request.getParameter("tprice")));
                String watch_hrs = request.getParameter("WHrs") + "h " + request.getParameter("WMin")+"m";
                movie1.setWatch_hrs(watch_hrs);
                movie1.setDirector(request.getParameter("direc"));
                movie1.setCategory(request.getParameter("category"));
                movie1.setImbd_rate(request.getParameter("imbd")+"/10");
                movie1.setRott_rate(request.getParameter("rott")+"%");
                movie1.setThumb(imageName);
                movie1.setMov_desc(request.getParameter("mov_desc"));
                
                //Attempts to perform a database insertion.
                int numRows = admin1.insertNewMovieDetails(movie1);
                if(numRows > 0) {
                    //if success
                    response.sendRedirect("Adashboard.jsp");
                }
                else {
                    //if fail
                    response.sendRedirect("Adashboard.jsp");
                }
            }
        
        
    }

}
