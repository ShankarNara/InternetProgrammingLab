import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class StudMark extends HttpServlet{

    Connection con ;
    PrintWriter pw;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{

        
        //setting up database connectivity
        res.setContentType("text/html");
        final String DBURL = "jdbc:mysql://localhost:3306/StudTable"; 
        final String user = "root";
        final String pass = "thenextgenius";
        pw = res.getWriter();
        pw.println("<html><body>");
        try{
            con = DriverManager.getConnection(DBURL,user,pass);
        } catch (Exception e){
            pw.println("<p>Don't mind me</p>");
        }

        
        pw.println("<p>Don't mind me</p>");
        //pw.println("<p>Don't mind me</p>");
        //Displaying Database content
        String id = req.getParameter("name");
        try{
            String sql = "select * from student where rno = "+id+";";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            pw.println("<table border='1'>");
            pw.println("<tr> <th>Name</th> <th>ID</th> </tr>");

            while(rs.next()){
                pw.println("<tr>");
                pw.println("<td>"+rs.getString("name") + "</td>");
                pw.println("<td>"+rs.getString("rno") + "</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        } catch (Exception e) {

        }

        pw.println("</body></html>");
    }
}