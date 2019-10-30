package project.com;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TrangChuController {
  @RequestMapping("/")
  public String index() {
    return "index";
  }
  @RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
  public String hello() {
    return "login";
  }
  
  @RequestMapping(value = "/check" , method =  RequestMethod.POST)
  public String login(HttpServletRequest req, HttpServletResponse rep, ModelMap model )
  {
	  String user = req.getParameter("user");
	  String pass = req.getParameter("pass");
	  if(user.equals("admin") && pass.equals("1234"))
	  {
		  model.addAttribute("message","Đăng nhập thành công");
		  return "index";
	  }
	  else
	  {
		  model.addAttribute("message","Đăng nhập thất bại");
		  return "index";
	  }  
  }
}