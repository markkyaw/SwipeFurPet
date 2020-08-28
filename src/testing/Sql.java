package testing;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;

public class Sql {
	static Connection conn;
	static PreparedStatement ps; 
	static ResultSet rs; 
	
	public static void initConnection() {
		if(conn != null)
			return; //connection has already been established
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password="
					+ "&serverTimezone=America/Chicago");
			System.out.println("Connection established!");
			ps = conn.prepareStatement("use SwipeFurPets"); 
			ps.execute(); 
		} catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException  sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		}
	} 
	
	//also update fields in adopter 
	public static int createAdopter(String fname, String lname, String email, String phone, String zipcode, String city, String password) {
		try {
			initConnection(); 
			//check if email exists
			ps = conn.prepareStatement("select * from Adopter where Email=?");
			ps.setString(1, email);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				return 1; 
			}
			ps = conn.prepareStatement("insert into Adopter (First_Name, Last_Name, Email, Phone, Zipcode, City, Password ) "
					+ "value (?, ?, ?, ?, ?, ?, ?)"); 
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, zipcode);
			ps.setString(6, zipcode);
			ps.setString(7, password);
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0; 
	}
	
	public static Preferences getPreference(String email) {
		Preferences p = null;
		try {
			initConnection();
			ps = conn.prepareStatement("select * from Preferences where Email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			rs.next();
			p = new Preferences(email,
					rs.getString("PetType"),
					rs.getString("Size"),
					rs.getString("Age"),
					rs.getInt("Children"),
					rs.getInt("Dogs"),
					rs.getInt("Cats"));
			} catch(SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			} 
		return p;
		
	}
	
	public static int createPet(int petID, String petName, String petType, String age, String size, String Rescue_ID, String ImgLink,
			int children, int dogs, int cats) {
		try {
			initConnection(); 
			//check if pet already exists
			ps = conn.prepareStatement("select * from Pet where Pet_ID=?");
			ps.setLong(1, petID);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				return 1; 
			}
			ps = conn.prepareStatement("insert into Pet (Pet_ID, Pet_Name, PetType, Age, Size, Rescue_ID, ImgLink, Children, Dogs, Cats ) "
					+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
			ps.setLong(1, petID);
			ps.setString(2, petName);
			ps.setString(3, petType);
			ps.setString(4, age);
			ps.setString(5, size);
			ps.setString(6, Rescue_ID);
			ps.setString(7, ImgLink);
			ps.setLong(8, children);
			ps.setLong(9, dogs);
			ps.setLong(10, cats);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0; 
	}
	
	
	//create match servlet that takes in the JSON 
	
	//get all messages in conversation
	//shoudl return List<Message>
	//get all adjacent message list 
	
	
	public static int validateLogin(String email, String password) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("select * from Adopter where Email=? and Password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				return 1;
			}
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
		return 0; 
	}
	
	//note: 1 is Adopter, 0 is Rescue
	public static void createMessage(int sender, int petID, String email, Timestamp time, String content) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("insert into Message (Sender, Pet_ID, Email, Date_Time, Content) "
					+ "value (?, ?, ?, ?, ?)"); 
			ps.setLong(1, sender);
			ps.setLong(2, petID);
			ps.setString(3, email);
			ps.setTimestamp(4, time);
			ps.setString(5, content);
			ps.executeUpdate();
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
		
	}
	
	public static int createRescue(String rescueID, String organization, String email, String phone, String link, String city, String zipcode) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("select * from Rescue where Rescue_ID=?");
			ps.setString(1, rescueID);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				return 1;
			}
			ps = conn.prepareStatement("insert into Rescue (Rescue_ID, Organization_Name, Email, Phone, Link, City, Zipcode) "
					+ "value (?, ?, ?, ?, ?, ?, ?)"); 
			ps.setString(1, rescueID);
			ps.setString(2, organization);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, link);
			ps.setString(6, city);
			ps.setString(7, zipcode);
			ps.executeUpdate();
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
		return 0; 
	}
	
	public static void createPreferences(String email, String petType, String size, String age, int children, int dogs, int cats) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("insert into Preferences (Email, PetType, Size, Age, Children, Dogs, Cats) "
					+ "value (?, ?, ?, ?, ?, ?, ?)"); 
			ps.setString(1, email);
			ps.setString(2, petType);
			ps.setString(3, size);
			ps.setString(4, age);
			ps.setLong(5, children);
			ps.setLong(6, dogs);
			ps.setLong(7, cats);
			ps.executeUpdate();
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
	}
	
	
	
	public static void updatePreferences(String email, String petType, String size, String age, int children, int dogs, int cats) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("UPDATE Preferences SET PetType=?, Size=?, Age=?, Children=?, Dogs=?, Cats=? WHERE Email=?"); 
			ps.setString(1, petType);
			ps.setString(2, size);
			ps.setString(3, age);
			ps.setLong(4, children);
			ps.setLong(5, dogs);
			ps.setLong(6, cats);
			ps.setString(7, email);
			ps.executeUpdate();
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
	}
	
	public static ArrayList<Message> getConvo(String email, Integer petID) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			initConnection();
			ps = conn.prepareStatement("select * from Message where Email=? and Pet_ID=?");
			ps.setString(1, email);
			ps.setInt(2, petID);
			rs = ps.executeQuery();
			while(rs.next()) {
				messages.add(new Message(rs.getInt("Sender"),
						rs.getString("Email"),
						rs.getInt("Pet_ID"),
						rs.getTimestamp("Date_Time"),
						rs.getString("Content")));
			}
		} catch(SQLException sqle) {
			System.out.println("sqle1: " + sqle.getMessage());
		} 
			
		return messages;
		
	}
	
	public static ArrayList<Message> getMessages(String email) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			initConnection();
			ps = conn.prepareStatement("select * from Message where Message_ID in (select max(Message_ID) from (select * from Message where Email=?) as S group by Pet_ID)");
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				messages.add(new Message(rs.getInt("Sender"),
						rs.getString("Email"),
						rs.getInt("Pet_ID"),
						rs.getTimestamp("Date_Time"),
						rs.getString("Content")));
			}
		} catch(SQLException sqle) {
			System.out.println("sqle2: " + sqle.getMessage());
		} 
		return messages;
		
	}
	
	public static void match(String email, int petID) {
		try { 
			initConnection();  
			ps = conn.prepareStatement("insert into Match (Email, Pet_ID) "
					+ "value (?, ?)"); 
			ps.setString(1, email);
			ps.setLong(2, petID);
			ps.executeUpdate();
		}
		catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage()); 
		} 
	}
	
	
	
}
