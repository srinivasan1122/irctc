package irctc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class irctc_check extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession sessiondummy=req.getSession();
		String username=(String)sessiondummy.getAttribute("un");
		String password=(String)sessiondummy.getAttribute("pw");
	  	res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
		if(username.equals("rakesh")&&password.equals("123"))
		{
			res.sendRedirect("irctcPlace.html");
		}
		else
		{
			out.println("login unsuccessful");
		}
		
	}
}
