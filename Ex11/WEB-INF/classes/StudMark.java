import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class StudMark extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try
		{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			//pw.println("Driver Loaded <br><br>");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studmark","root","Chennai_5");
			//pw.println("After Connection <br><br>");
			String rollno=req.getParameter("regno");
			String sql="Select sub1,m1,sub2,m2,sub3,m3 from Marks where regno="+rollno+";";
			String sql1 = "select * from Mapping";
			Statement stmt=con.createStatement();
			//pw.println("After createStatement <br><br>");
			ResultSet rs=stmt.executeQuery(sql);
			
			String n1 = "select subname from Mapping ;";
			//pw.println("After executeQuery <br><br><br>");
			while(rs.next())
			{
				pw.println("Regno : "+rollno+"<br>");
				String s1=rs.getString("sub1");
				String s2=rs.getString("sub2");
				String s3=rs.getString("sub3");
				int m1=rs.getInt("m1");
				int m2=rs.getInt("m2");
				int m3=rs.getInt("m3");
				pw.println(s1+" "+m1+" "+"Maths"+"<br>");
				pw.println(s2+" "+m2+" "+"Science"+"<br>");
				pw.println(s3+" "+m3+" "+"English"+"<br>");
			}
			//pw.println("After Display");
		}
		catch(SQLException e)
		{
			pw.println("SQLException");
		}
		catch(ClassNotFoundException e)
		{
			pw.println("Driver not loaded");
		}
		pw.close();
	}
}
