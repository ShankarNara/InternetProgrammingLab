import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class crudd extends HttpServlet {
	Connection con = null;
	PrintWriter pw;
	Statement st = null;
	PreparedStatement ps = null, psd = null;
	ResultSet rs = null;
	public void display_boom_boom(String fideid) {
		try {
			String sql = "select * from student where rno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fideid);
			rs = ps.executeQuery();
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<th> Rno </th>");
			pw.println("<th> Name </th>");
			pw.println("</tr>");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getString("rno") +  "</td>");
				pw.println("<td>" + rs.getString("name") + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}
		catch(Exception E) {
			pw.println(E);
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		final String DBURL = "jdbc:mysql://localhost:3306/StudTable";
		final String user = "root";
		final String pass = "thenextgenius";
		pw = res.getWriter();
		/*v imp */
		try {
			con = DriverManager.getConnection(DBURL, user, pass);
		}
		catch(Exception E) {
			pw.println(E);
		}
		/*v imp */
		String clicked = req.getParameter("seek");
		if(clicked.equals("d")) {
			try {
				
				String query = "delete from student where rno = ?";
				psd = con.prepareStatement(query);
				String fideid = (String)req.getParameter("rolld");
				psd.setString(1, fideid);
				display_boom_boom(fideid);
				psd.executeUpdate();
				pw.println("<h1> Deleted the above record from DB </h1>");
				
				con.close();
			}
			catch(Exception E) {
				pw.println(E);		
			}
		}
		else if(clicked.equals("u")) {
			try {
				con = DriverManager.getConnection(DBURL, user, pass);
				ps = con.prepareStatement("update student set name = ? where rno = ?;");
				String fideid = (String)req.getParameter("rollu");
				String fname = (String)req.getParameter("nameu");
				ps.setString(2, fideid);
				ps.setString(1, fname);
				ps.executeUpdate();
				pw.println("<h1> Updated your name to " + fname + "</h1>");
				con.close();
			}
			catch(Exception E) {
				pw.println(E);		
			}
		}
		else if(clicked.equals("i")) {
			try {
				ps = con.prepareStatement("insert into student values(?, ?)");
				String fideid = (String)req.getParameter("roll");
				String fname = (String)req.getParameter("name");
				ps.setString(1, fname);
				ps.setString(2, fideid);
				pw.println(fideid);
				pw.println(fname);
				ps.executeUpdate();
				pw.println("<h1> Above new row is inserted </h1>");
				con.close();
			}
			catch(Exception E) {
				pw.println(E);		
			}
		}
		else if(clicked.equals("r")) {
			try {
				String fideid = (String)req.getParameter("rollr");
				display_boom_boom(fideid);
				pw.println("<h1> Above are your retrieved details </h1>");
				con.close();
			}
			catch(Exception E) {
				pw.println(E);		
			}
		}
	}
	
	
}
