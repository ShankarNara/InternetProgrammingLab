package Bean;

public class UserBean {

    String user;
    String pass;
    public UserBean (String user,String pass){
        this.user = user;
        this.pass = pass;
    }

    public void set(String u,String p){
        this.user=u;
        this.pass=p;
    }

    public String getUser(){
        return user;
    }

    public String getPass(){
        return pass;
    }
}