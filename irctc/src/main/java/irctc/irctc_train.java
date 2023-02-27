package irctc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class irctc_train extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		String date=req.getParameter("date"); 
		res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
		if(from.equals("null")&&to.equals("null")&&date.equals("null"))
		{
			out.println("please fill FROM and TO cities to proceed");		
		}
		else
		{
			out.println("FROM "+from+" TO "+to+" on "+date);	
			res.sendRedirect("details.html");
		}
	}
}
