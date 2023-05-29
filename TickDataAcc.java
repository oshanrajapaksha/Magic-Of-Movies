
package DatAcc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jv.Ticket;
public class TickDataAcc {
    private Connection databaseConnection;

    public TickDataAcc() {
        databaseConnection = new ConnectionProvider().getMySQLConnection();
    }

    public int insertTicket(Ticket ticket) {
         LocalDate currDate = LocalDate.now();
        
        int  numRecords = 0;
        try {
                String query="INSERT INTO `ticket` (`ticket_id`, `mov_id`, `user`, `Time`, `no_of_tickets`, `total`) VALUES (NULL, ?, ?, ?, ?, ?);";
                
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                pStatement.setInt(1, ticket.getMid());
                pStatement.setString(2, ticket.getEmail());
                pStatement.setString(3, String.valueOf(currDate));
                pStatement.setInt(4, ticket.getNoTicket());
                pStatement.setDouble(5, ticket.getTotal());
                numRecords = pStatement.executeUpdate();
        }
        catch(SQLException e) {
                System.out.println(e.getMessage());
        }
        return numRecords;
    }

    public List<Ticket> getTicketsByEmail(Ticket inputTicket) {
        List<Ticket> ticketList = new ArrayList<>();	
        try {
            
            String query="select * from ticket where user = ?;";
            
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            
            pStatement.setString(1, inputTicket.getEmail());
            
            ResultSet result = pStatement.executeQuery();
            
            while(result.next()) {
                
                Ticket ticket=new Ticket();
                
                ticket.setId(result.getInt("ticket_id"));
                ticket.setMid(result.getInt("mov_id"));
                ticket.setEmail(result.getString("user"));
                ticket.setDate(result.getString("Time"));
                ticket.setNoTicket(result.getInt("no_of_tickets"));
                ticket.setTotal(result.getDouble("total"));
                ticketList.add(ticket);
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return ticketList;
    }

    
    public Ticket getTicketRecord(Ticket ticket) {
        try {
            String query = "select * from ticket where id = ?;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            pStatement.setInt(1, ticket.getId());
      
            ResultSet result = pStatement.executeQuery();
            while(result.next()) {
                ticket.setEmail(result.getString("user"));
                ticket.setMid(result.getInt("mov_id"));
                ticket.setId(result.getInt("ticket_id"));	
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return ticket;
    }

    public int deleteTicketRecord(Ticket ticket) {
        int numRows = 0;
        try {
            
            String query = "delete from ticket where ticket_id = ?;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            pStatement.setInt(1, ticket.getId());
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRows;
    }
    
    public List<Ticket> getAllTicketRecords(){
        List<Ticket> ticketList;
        ticketList = new ArrayList<>();
        try {
            String query="SELECT * FROM `ticket`;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            ResultSet results = pStatement.executeQuery();
            while(results.next()) { 
                Ticket ticketRecord = new Ticket();
                ticketRecord.setMid(results.getInt("mov_id"));
                ticketRecord.setEmail(results.getString("user"));
                ticketRecord.setDate(results.getString("Time"));
                ticketRecord.setId(results.getInt("ticket_id"));
                ticketRecord.setNoTicket(results.getInt("no_of_tickets"));
                ticketRecord.setTotal(results.getDouble("total"));
                ticketList.add(ticketRecord);
            }
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        return ticketList;
    }
    
}
