package irctc;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class irctc_servlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String username=req.getParameter("uname");
		String password=req.getParameter("pwd");
		HttpSession session1=req.getSession(true);
		session1.setAttribute("un",username);
		session1.setAttribute("pw",password);
		res.sendRedirect("irctc_check");
	}
}