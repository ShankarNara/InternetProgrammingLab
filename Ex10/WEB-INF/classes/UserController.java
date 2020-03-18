import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Bean.UserBean;
import DAO.UserDAO;

public class UserController extends HttpServlet{

    String User;
    String Pass;
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        User = req.getParameter("user");
        Pass = req.getParameter("pass");
        UserBean bean = new UserBean(User,Pass);
        //bean.set(User,Pass);
        UserDAO dao = new UserDAO();
        int r = dao.getResult(bean);
        if(r==1){
            req.getRequestDispatcher("/success.jsp").forward(req,res);
        } else {
            req.getRequestDispatcher("/failure.jsp").forward(req,res);
        }
    }
}