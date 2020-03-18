import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SessionServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        //pw.println("<h2>success!</h2>");

        //Session code
        HttpSession session = req.getSession();
        Integer hit = (Integer) session.getAttribute("gethit");

        if(hit == null){
            hit = new Integer(1);
        } else {
            hit = new Integer(hit.intValue()+1);
        }

        session.setAttribute("gethit",hit);

        pw.println("<h3>Hit count</h3>");
        pw.println("<br>Hit count for session Id : "+session.getId()+"<br>Your current hit count : "+hit);
    }
}