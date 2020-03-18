package DAO;
import java.sql.*;
import Bean.EvalBean;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class EvalDao {
	public EvalBean getAnswers() {
		Connection con;
		Statement st;
		ResultSet rs;
		int count = 0;
		List<String> answers = new ArrayList<>();
		EvalBean evalBean = new EvalBean();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab","root","thenextgenius");
			st = con.createStatement();
			String sql = "select answer from questions";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				count++;
				answers.add(rs.getString(1));
			}
			evalBean.set(answers,count);
		} catch(Exception e) {
		

		}
		return evalBean;
	}
}
