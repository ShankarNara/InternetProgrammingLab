import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class genBill extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		Cookie c[] = req.getCookies();
		String user = c[0].getValue();
		String category = c[1].getValue();
		if(category.equals("v")) category = "Vegetarian";
		else category = "Non Vegetarian";

		String[] items = {"Butter Masala", "thokku", "Chilli Burger", "Biryani"};
		int[] cost = {120, 100, 70, 90};
		int i, grandTotal = 0;
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<script>");
		pw.println("function success() {");
		pw.println("document.getElementById('success').innerHTML = 'Payment Successful';");
		pw.println("}");
		pw.println("</script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div style='text-align: center;'>");
		pw.println("<h1>Your Bill</h2><br>");
		pw.println("<table style='margin-left: auto; margin-right: auto;'>");
		pw.println("<tr><th>Customer Name</th><td colspan=2>"+user+"</td></tr>");
		pw.println("<tr><th>Category</th><td colspan=2>"+category+"</td></tr>");
		pw.println("<tr><th>Item Name</th><th>Cost(each)</th><th>Cost(Total)</th></tr>");
		for(i = 0; i<items.length; i++) {
			String itemName = String.format("item%d",i);
			int quantity = Integer.parseInt(req.getParameter(itemName));
			if(quantity>0) {
				if(category.equals("Vegetarian")) cost[i] += 20;
				else cost[i] += 60;
				int costItem = cost[i]*quantity;
				grandTotal += costItem;
				pw.println("<tr><td>"+items[i]+"</td><td>"+cost[i]+"</td><td>"+costItem+"</td></tr>");
			}
		}
		pw.println("<tr><th>Grand Total</th><td colspan=2>"+grandTotal+"</td></tr>");
		pw.println("</table><br>");
		pw.println("<button onclick='success();'>Pay Bill</button><br><br>");
		pw.println("<a href='index.html'>Home Page</a>");
		pw.println("</div><br>");
		pw.println("<div style='text-align: center;' id='success'></div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
