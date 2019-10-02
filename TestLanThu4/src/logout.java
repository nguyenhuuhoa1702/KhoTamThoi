import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 

@SuppressWarnings("serial")
public class logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();          
	     request.getRequestDispatcher("index.html").include(request, response);  
	     
	     // cach 1     
	     Cookie[] ck = request.getCookies();
	     //String str =  request.getCookies().toString();
	     //out.print(str); 
	     if(ck != null)
	     {
		     for (int i = 0 ; i  < ck.length; i++)
				{
					Cookie  ck1 = ck[i];
					ck1.setMaxAge(0);  
					response.addCookie(ck1);  
				}
		     out.print("xoa cookie thanh cong. kho ghe!");  
	     }
	     else
	     {
	    	 out.print("khong co cookie");  
	     }
	     
	     HttpSession session = request.getSession();
	     if (session.getAttribute("user1") != null )
	     {
	    	 session.invalidate();
	    	 out.print("\n Xoa thanh cong session");
	     }
	     else
	     {
	    	 out.print("\n Khong co ssesion de xoa");
	     }
	     
	     
	     // cach 2:  khong hieu qua... khong biet ly do
	     //Cookie ck=new Cookie("user","");  
	     //ck.setMaxAge(0);  
	     //response.addCookie(ck);  
	          
	     //out.print("you are successfully logged out!");  
	     
	}
	
}