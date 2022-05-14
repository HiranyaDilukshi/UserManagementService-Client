package com;
import com.Login;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginAPI")
public class LoginAPI extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	Login loginObj = new Login();
	
	public LoginAPI()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
			 HttpSession session = request.getSession();
			 String authStatus = loginObj.login(request.getParameter("txtUsername"),
			 request.getParameter("txtPassword"));
			 String output = "";
			if (authStatus.equals("success"))
			 {
			 output = "{\"status\":\"success\", \"data\": \"\"}";
			 session.setAttribute("Username",
			 request.getParameter("txtUsername"));
			 }
			else
			 {
			 output = "{\"status\":\"error\", \"data\": \"" + authStatus + "\"}";
			 }
			 response.getWriter().write(output);
			}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			 HttpSession session = request.getSession();
			session.invalidate();
			response.getWriter().write("success");
			}
	
}