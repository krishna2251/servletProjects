package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class LoginServlet extends GenericServlet {
public void service(ServletRequest req,ServletResponse res)
throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String uName=req.getParameter("uname");
	String pWord=req.getParameter("pword");
	try{
		Connection con=DBConnection.getcon();
		PreparedStatement ps=con.prepareStatement("select * from register8 where uname=? and pword=?");
		ps.setString(1,uName);
		ps.setString(2, pWord);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			RequestDispatcher rd=req.getRequestDispatcher("dis");
			rd.forward(req, res);
		}//end of if
		else{
			pw.println("Invalid UserName and PassWord");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
	}//end of try
	catch(Exception e){e.printStackTrace();}
		}
	
}

