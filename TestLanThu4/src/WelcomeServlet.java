import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
	// class xu ly
public class WelcomeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Cookie[] ck = request.getCookies();
		
		if ( ck != null)
		{
			for (int i = 0 ; i  < ck.length; i++)
			{
				Cookie  ck1 = ck[i];				
				out.print("Hello " + ck1.getValue() + " by cookie \n");
			}
		}
		if(session.getAttribute("user1") != null)
		{
			out.print("Hello " + session.getAttribute("user1").toString() + " by Session \n");
		}
	//	out.print("Welcome " + request.getParameter("user"));
		
	}
}