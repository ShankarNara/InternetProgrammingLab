import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Bean.ExamBean;
import DAO.ExamDao;

public class ExamController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ExamBean examBean = new ExamBean();
		ExamDao examDAO = new ExamDao();
		examBean = examDAO.getQuestions();
		HttpSession session = req.getSession(true);
		session.setAttribute("questions",examBean.getQ());
		session.setAttribute("op1",examBean.getOp1());
		session.setAttribute("op2",examBean.getOp2());
		session.setAttribute("op3",examBean.getOp3());
		session.setAttribute("op4",examBean.getOp4());
		session.setAttribute("length",examBean.getLength());

		req.getRequestDispatcher("/quiz.jsp").forward(req,res);
	}
}
