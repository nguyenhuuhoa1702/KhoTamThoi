import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@SuppressWarnings("serial")
public class TestJava extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		// kiem tra ben Cookie
		if(user.equals("admin"))
		{
			switch(pass)
			{
				case "cookie": 
				{
					// String n=request.getParameter("user")
					Cookie cookie = new Cookie("cookie",user);
					// thiet lap thoi gian song cookie
					cookie.setMaxAge(60 * 60);
					// them cookie vao client
					response.addCookie(cookie);
					// rq toi trang nao
					RequestDispatcher rd = request.getRequestDispatcher("/check2");
					//out.print("xin chao " + user);
					rd.forward(request, response);
				} 
				break;
				case "session":
				{
					HttpSession session = request.getSession();
					session.setAttribute("user1", user);
					RequestDispatcher rd = request.getRequestDispatcher("/check2");
					out.print("xin chao " + user);
					rd.forward(request, response);
					//out.print("xin chao abc");
				} 
				break;
				default:
					out.print("Sai mat khau");
					break;
			}
		}
		else
		{
			out.println("Tài khoản không phai la cookie hoac Session thể nào là không sai !");
			RequestDispatcher rd  = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		out.close();
	}
	
}
