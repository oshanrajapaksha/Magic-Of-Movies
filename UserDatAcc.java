package DatAcc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jv.User;

public class UserDatAcc {
    
	private final Connection databaseConnection;
	public UserDatAcc() {
            this.databaseConnection = new ConnectionProvider().getMySQLConnection();
        }
        
        
	public int insertNewUser(User user) {//USED FOR REGISTRATION
            int numRows = 0;
            try {
                String query="INSERT INTO `users` (`email`, `name`, `dob`, `address`, `password`, `prof_pic`, `role`, `messege`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                
                
                pStatement.setString(1, user.getEmail());
                pStatement.setString(2, user.getName());
                pStatement.setString(3, user.getDob());
                pStatement.setString(4, user.getAddress());
                pStatement.setString(5, user.getPassword());
                pStatement.setString(6, user.getProfPic());
                pStatement.setString(7, user.getRole());
                pStatement.setString(8, user.getAdMsg());
                numRows = pStatement.executeUpdate();
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }catch(Exception e1){
                System.out.println(e1.getMessage());
            }
            return numRows;
	}
	
	public int checkUserRole(User user) {//USED FOR LOGIN
            int roleIndex = 0;
            try {
                String query="SELECT * FROM users WHERE email=? AND password=?";
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                pStatement.setString(1, user.getEmail());
                pStatement.setString(2,user.getPassword());
                ResultSet result = pStatement.executeQuery();
                if(result.next()) {
                    
                    String role = result.getString("role");
                    
                        switch (role) {
                            
                            case "User":
                                roleIndex = 1;
                                break;
                            case "Admin":
                                roleIndex = 2;
                                break;
                            default:
                                roleIndex = 0;
                        }
                }
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            return roleIndex;
	}

	public int updateUserRecords(User user) {
		int numRows = 0;
		try {
			String query="update users password = ?, address = ? where email = ?;";
			PreparedStatement pStatement = databaseConnection.prepareStatement(query);
			pStatement.setString(1, user.getPassword());
			pStatement.setString(2, user.getAddress());
			pStatement.setString(3, user.getEmail());
			numRows = pStatement.executeUpdate();
			
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return numRows;
	}
        public int upgradeUserToAnAdmin(String uEmail) {// promoting user to an administrator.
		int numRows = 0;
		try {
			String query = "UPDATE `users` SET `role` = 'Admin' WHERE `users`.`email` = ?;";
                        String sql = "UPDATE users set messege = '' where users.messege = ?;";
                        PreparedStatement p2 = databaseConnection.prepareStatement(sql);
			PreparedStatement p = databaseConnection.prepareStatement(query);
			p.setString(1, uEmail);
                        p2.setString(1, uEmail);
                        p2.executeUpdate();
                        if(p.executeUpdate() > 0){
                            numRows = 1;
                        }else{
                            numRows = 0;
                        }
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return numRows;
	}
        
        public int deleteUserRequest(String uEmail){
            int numRows = 0;
            
            try {
			String query = "UPDATE `users` SET `role` = 'User' WHERE `users`.`email` = ?;";
                        String sql = "UPDATE users set messege = '' where users.messege = ?;";
                        PreparedStatement p2 = databaseConnection.prepareStatement(sql);
			PreparedStatement p = databaseConnection.prepareStatement(query);
                        p2.setString(1, uEmail);
			p.setString(1, uEmail);
                        p2.executeUpdate();
                        if(p.executeUpdate() > 0){
                            numRows = 1;
                        }else{
                            numRows = 0;
                        }
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
            
            return numRows;

        }
	
}
