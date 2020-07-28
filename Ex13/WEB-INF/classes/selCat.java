import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class selCat extends HttpServlet {
	private String user;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.user = this.getInitParameter(req.getParameter("user"));
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie usr = new Cookie("user", this.user);
		res.addCookie(usr);

		pw.println("<html>");
		pw.println("<body>");
		pw.println("<div style='text-align: center;'>");
		pw.println("<p>Welcome "+this.user+"</p>");
		pw.println("<p>Choose a Food Category</p><br>");
		pw.println("<form action = 'itemlist' method = 'get'>");
		pw.println("<select name='category'>");
		pw.println("<option value='v'>Vegetarian</option>");
		pw.println("<option value='nv'>Non Veg</option>");
		pw.println("</select><br><br>");
		pw.println("<input type = 'submit' value = 'Show Menu'>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
