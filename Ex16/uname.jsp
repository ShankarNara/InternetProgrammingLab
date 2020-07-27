<%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudTable","root","thenextgenius");  
PreparedStatement ps=con.prepareStatement("select * from students");  
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
out.print(rs.getString(1));  
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  
}  
%>  