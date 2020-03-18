import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Bean.EvalBean;
import DAO.EvalDao;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class EvalController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		EvalBean evalBean = new EvalBean();
		EvalDao evalDAO = new EvalDao();
		evalBean = evalDAO.getAnswers();

		List<String> answers = new ArrayList<>();
		answers = evalBean.getA();

		int score= 0 ;

		for(int i=0;i<evalBean.getLength();i++) {
			if(req.getParameter("q" + (i+1)).equals(answers.get(i))) {
				score++;
			}
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("score",score);

		req.getRequestDispatcher("/score.jsp").forward(req,res);

	}
}
