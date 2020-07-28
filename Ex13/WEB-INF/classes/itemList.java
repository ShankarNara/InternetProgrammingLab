import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class itemList extends HttpServlet {
	private String category;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie c[] = req.getCookies();
		String user = c[0].getValue();
		Cookie userc = new Cookie("user", user);
		this.category = req.getParameter("category");
		Cookie cat = new Cookie("Category", this. category);
		String[] items = {"Butter Masala", "thokku", "Chilli Burger", "Biryani"};
		int[] cost = {120, 100, 70, 90};
		int i;
		res.addCookie(userc);
		res.addCookie(cat);

		if(this.category.equals("v")) {
			for(i = 0; i<items.length; i++) {
				if(i%2==0) items[i] = "Paneer " + items[i];
				else items[i] = "Veg " + items[i];
				cost[i] += 20;
			}
		}
		else if (this.category.equals("nv")) {
			for(i = 0; i<items.length; i++) {
				if(i%2==0) items[i] = "Chicken " + items[i];
				else items[i] = "Mutton " + items[i];
				cost[i] += 60;
			}	
		}
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<div style='text-align: center;'>");
		pw.println("<p>Menu</p><br>");
		pw.println("<p>Maximum quantity of each item = 5</p><br>");
		pw.println("<form action = 'billgen' method = 'get'>");
		pw.println("<table style='margin-left: auto; margin-right: auto;'>");
		pw.println("<tr><th>Item</th><th>Cost</th></tr>");
		for(i = 0; i<items.length; i++) {
			pw.println("<tr><td>"+items[i]+"</td><td>"+cost[i]+"</td>");
			pw.println("<td><input name='item"+i+"'style='width: 70px;' type='number' min=0 max=5 value=0></td></tr>");
		}
		pw.println("</table><br>");
		pw.println("<input type = 'submit' value = 'Generate Bill'>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
