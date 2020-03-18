package DAO;
import java.sql.*;
import Bean.ExamBean;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class ExamDao {
	public ExamBean getQuestions() {
		Connection con;
		Statement st;
		ResultSet rs;
		int count = 0;
		List<String> questions = new ArrayList<>();
		List<String> op1 = new ArrayList<>();
		List<String> op2 = new ArrayList<>();
		List<String> op3 = new ArrayList<>();
		List<String> op4 = new ArrayList<>();
		ExamBean examBean = new ExamBean();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab","root","thenextgenius");
			st = con.createStatement();
			String sql = "select * from questions";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				count++;
				questions.add(rs.getString(1));
				op1.add(rs.getString(2));
				op2.add(rs.getString(3));
				op3.add(rs.getString(4));
				op4.add(rs.getString(5));
			}
			examBean.set(questions,op1,op2,op3,op4,count);
		} catch(Exception e) {
		

		}
		return examBean;
	}
}
