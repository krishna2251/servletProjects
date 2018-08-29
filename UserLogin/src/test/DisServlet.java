package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet {
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String uName=req.getParameter("uname");
	pw.println("user Login Successfully...");
	pw.println("<br>welcome:"+uName);
}
}
