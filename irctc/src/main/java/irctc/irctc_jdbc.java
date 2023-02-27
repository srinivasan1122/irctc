package irctc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class irctc_jdbc {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String userName = "root";
		String passWord = "r514266s";
		String query = "SELECT * FROM irctc";
		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		System.out.println("train_id is "+rs.getInt(1));
		System.out.println("train_name is "+rs.getString(2));
		System.out.println("cost_of_2s is "+rs.getInt(3));

		con.close();
	}
}