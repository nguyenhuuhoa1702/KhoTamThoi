import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 

@SuppressWarnings("serial")
public class XuLyProfile extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//lay full cookie
		Cookie[] ck = request.getCookies();
		if ( ck != null)
		{
			for (int i = 0 ; i  < ck.length; i++)
			{
				Cookie  ck1 = ck[i];				
				out.print("Hello " + ck1.getValue() + " wecome to profile by cookie " + "\n");
			}
		}
		else
		{
			// dua ra thong tin
			out.print("Chua dang nhap ma xem xem cai gi !!! ");
			// quy dinh trang hien thi thong tin
			RequestDispatcher rd  = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			
		//	request.getRequestDispatcher("/index.html").include(request, response);	
		}
		
	}
}

