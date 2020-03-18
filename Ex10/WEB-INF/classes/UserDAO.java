package DAO;

import java.sql.*;
import java.util.*;
import Bean.UserBean;
public class UserDAO {

    Connection con;
    Statement st;
    ResultSet rs;

    public int getResult(UserBean bean){
        String DBURL = "jdbc:mysql://localhost:3306/iplab";
        String USER = "root";
        String PASS = "thenextgenius";
        int flag=0;

        try {
            con = DriverManager.getConnection(DBURL,USER,PASS);
            st=con.createStatement();
            String sql = "select * from list";
            rs = st.executeQuery(sql);
            while(rs.next()){
                String userdb = rs.getString("user");
                String passdb = rs.getString("pass");

                if(userdb.equals(bean.getUser()) && passdb.equals(bean.getPass())){
                    return 1;
                }
            }
        } catch (Exception e){

        }

        return 0;
    }
}