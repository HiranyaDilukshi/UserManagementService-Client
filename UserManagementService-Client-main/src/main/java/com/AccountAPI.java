package com;
import com.Account;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AccountAPI")
public class AccountAPI extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	Account accobj = new Account();
	
	public AccountAPI()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			 System.out.println("requets recieved");
		String output = accobj.insertAccount(request.getParameter("accountno"),
			request.getParameter("premisesid"),
			request.getParameter("areaoffice"),
		   request.getParameter("tarifftype"));
		 	 
			response.getWriter().write(output);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 String output = accobj.updateAccount(paras.get("hidAccountIDSave").toString(),paras.get("accountno").toString(),
					 paras.get("premisesid").toString(),paras.get("areaoffice").toString(),paras.get("tarifftype").toString());
			 
			response.getWriter().write(output);
	} 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			 Map paras = getParasMap(request);
			 
			 String output = accobj.deleteAccount(paras.get("accountID").toString().trim());
			 System.out.println(paras.get("accountID").toString());
			 response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try
		{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params)
			{ 
	
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}
}