package test;
import java.sql.*;
public class DBConnection {
private static Connection con;
static{
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	 	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	} //end of try
	catch(Exception e){}
} //end of block
public static Connection getcon(){
	return con;
	}
}

