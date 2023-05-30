package DatAcc;


import jv.Movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDataAccess {
    private final Connection databaseConnection;

    public MovieDataAccess() {
        this.databaseConnection = new ConnectionProvider().getMySQLConnection();
    }
        
   
    public List<Movies> getAllMoviesRecords(){
        List<Movies> moviesList;
        moviesList = new ArrayList<>();
        try {
            String query="select * from movies;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            ResultSet results = pStatement.executeQuery();
            while(results.next()) { 
                Movies moviesRecord = new Movies();
                moviesRecord.setM_id(results.getInt("m_id"));
                moviesRecord.setName(results.getString("name"));
                moviesRecord.setTicket_price(results.getDouble("ticket_price"));
                moviesRecord.setExpire_time(results.getString("expire_time"));
                moviesRecord.setTime_inserted(results.getString("time_inserted"));
                moviesRecord.setCategory(results.getString("category"));
                moviesRecord.setDirector(results.getString("director"));
                moviesRecord.setImbd_rate(results.getString("imbd_rate"));
                moviesRecord.setRott_rate(results.getString("rott_rate"));
                moviesRecord.setWatch_hrs(results.getString("watch_hrs"));
                moviesRecord.setThumb(results.getString("thumb"));
                moviesRecord.setMov_desc(results.getString("mov_desc"));
                
                moviesList.add(moviesRecord);
            }
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        return moviesList;
    }
    
    
    public int insertMoviesRecord(Movies movies) {
        int numRows = 0;
        try {
            String query = "INSERT INTO `movies` (`m_id`, `name`, `ticket_price`, `expire_time`, `time_inserted`, `watch_hrs`, `director`, `category`, `imbd_rate`, `rott_rate`, `thumb`, `mov_desc`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            
            pStatement.setString(1, movies.getName());
            pStatement.setDouble(2, movies.getTicket_price());
            pStatement.setString(3, movies.getExpire_time());
            pStatement.setString(4, movies.getTime_inserted());
            pStatement.setString(5, movies.getWatch_hrs());
            pStatement.setString(6, movies.getDirector());
            pStatement.setString(7, movies.getCategory());
            pStatement.setString(8, movies.getImbd_rate());
            pStatement.setString(9, movies.getRott_rate());
            pStatement.setString(10, movies.getThumb());
            pStatement.setString(11, movies.getMov_desc());
            
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRows;
    }

    public int updateMoviesRecord(Movies movies) {
        int numRows = 0;
        try {
            String query = "UPDATE `movies` SET `name` = ?, `ticket_price` = ?, `expire_time` = ?, `time_inserted` = ?, `watch_hrs` = ?, `director` = ?, `category` = ?, `imbd_rate` = ?, `rott_rate` = ?, `thumb` = ?, `mov_desc` = ? WHERE `movies`.`m_id` = ?;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            pStatement.setInt(12, movies.getM_id());
            pStatement.setString(1, movies.getName());
            pStatement.setDouble(2, movies.getTicket_price());
            pStatement.setString(3, movies.getExpire_time());
            pStatement.setString(4, movies.getTime_inserted());
            pStatement.setString(5, movies.getWatch_hrs());
            pStatement.setString(6, movies.getDirector());
            pStatement.setString(7, movies.getCategory());
            pStatement.setString(8, movies.getImbd_rate());
            pStatement.setString(9, movies.getRott_rate());
            pStatement.setString(10, movies.getThumb());
            pStatement.setString(11, movies.getMov_desc());
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return numRows;
    }
    
    public Movies getMovieData(int mID){
        Movies moviesRecord;
        moviesRecord = new Movies();
        try {
            String query = "SELECT * FROM movies WHERE m_id = ?";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            pStatement.setInt(1, mID);
            ResultSet results = pStatement.executeQuery();
            while(results.next()) { 
                
                moviesRecord.setM_id(results.getInt("m_id"));
                moviesRecord.setName(results.getString("name"));
                moviesRecord.setTicket_price(results.getDouble("ticket_price"));
                moviesRecord.setExpire_time(results.getString("expire_time"));
                moviesRecord.setTime_inserted(results.getString("time_inserted"));
                moviesRecord.setCategory(results.getString("category"));
                moviesRecord.setDirector(results.getString("director"));
                moviesRecord.setImbd_rate(results.getString("imbd_rate"));
                moviesRecord.setRott_rate(results.getString("rott_rate"));
                moviesRecord.setWatch_hrs(results.getString("watch_hrs"));
                moviesRecord.setThumb(results.getString("thumb"));
                moviesRecord.setMov_desc(results.getString("mov_desc"));
                
            }
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        return moviesRecord;
    }

    public int deleteMoviesRecord(Movies movies) {
     
        int numRows = 0;
        try {
            String query="delete from movies where m_id = ?;";
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            pStatement.setInt(1, movies.getM_id());
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return numRows;
    }
}
