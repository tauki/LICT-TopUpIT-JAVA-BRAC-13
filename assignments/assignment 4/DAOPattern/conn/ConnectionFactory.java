package conn;
import java.sql.*;
public class ConnectionFactory
	{
		static String url="jdbc:mysql://localhost:3306/bracu";
		static String una="root";
		static String pwd="";
		public static Connection getCon()throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con=DriverManager.getConnection(url,una,pwd);
			return con;
		}
	}