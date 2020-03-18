<%@ page import="java.util.*,java.util.List,java.util.ArrayList" %>
<html>
<body>
<%
	List<String> questions,op1,op2,op3,op4;
	int length;
	questions = new ArrayList<>();
	op1 = new ArrayList<>();
	op2 = new ArrayList<>();
	op3 = new ArrayList<>();
	op4 = new ArrayList<>();

	questions = (ArrayList<String>)session.getAttribute("questions");
	op1 = (ArrayList<String>)session.getAttribute("op1");
	op2 = (ArrayList<String>)session.getAttribute("op2");
	op3 = (ArrayList<String>)session.getAttribute("op3");
	op4 = (ArrayList<String>)session.getAttribute("op4");
	length = (int)session.getAttribute("length");
	
	
	out.println("<form action = 'EvalController',method='get'>");
	out.println("<ol>");	
	for(int i=0;i<length;i++) {
		out.println("<br><li>" + questions.get(i) + "<br><input type=radio value=\"" + op1.get(i) + "\" name = q"+ (i+1) +" />" + 
			op1.get(i) + "<br><input type=radio value=\"" + op2.get(i) + "\" name = q" + (i+1) +" />" + op2.get(i) + 
			"<br><input type=radio value=\"" + op3.get(i) + "\" name = q"+ (i+1) +" />" + op3.get(i) + 
			"<br><input type=radio value=\"" + op4.get(i) + "\" name = q"+ (i+1) +" />" + op4.get(i) + "<br><br></li>");
	}
	out.println("</ol>");
	out.println("<br><button type='submit'>Submit</button>");
	out.println("</form>");
%>
</body>
</html>
