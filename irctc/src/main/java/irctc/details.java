package irctc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class details extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String INSERT_QUERY = "INSERT INTO USER(NAME,GENDER,AGE,SEAT) VALUES(?,?,?,?)";

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw = res.getWriter();
        res.setContentType("text/hmtl");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String seat = req.getParameter("seat");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) { 
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //create the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///jdbc","root","r514266s");
                PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
            //set the values
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, age);
            ps.setString(4, seat);

            //execute the query
            int count = ps.executeUpdate();

            if(count==0) {
                pw.println("Record not stored into database");
            }else {
                pw.println("Record Stored into Database");
            }
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }catch(Exception e) {
            pw.println(e.getMessage());
            e.printStackTrace();
        }

        //close the stream
        pw.close();
    }
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, res);
    }
}

