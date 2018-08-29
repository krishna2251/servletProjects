package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class RegServlet extends GenericServlet {
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String uName=req.getParameter("uname");
	String pWord=req.getParameter("pword");
	String fName=req.getParameter("firstname");
	String lName=req.getParameter("lastname");
	String Addr=req.getParameter("address");
	long pNo=Long.parseLong(req.getParameter("phoneno"));
	String mId=req.getParameter("mailid");
	try{
		Connection con=DBConnection.getcon();
		PreparedStatement ps=con.prepareStatement("insert into register8 values(?,?,?,?,?,?,?)");
		ps.setString(1, uName);
		ps.setString(2, pWord);
		ps.setString(3, fName);
		ps.setString(4, lName);
		ps.setString(5, Addr);
		ps.setLong(6,pNo);
		ps.setString(7, mId);
		int k=ps.executeUpdate();
		if(k==1)
		{
			pw.println("User Registerd Successfull....");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
	}// end of try
	catch(Exception e){e.printStackTrace();}
		}
	}

