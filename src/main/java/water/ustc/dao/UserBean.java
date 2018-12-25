package water.ustc.dao;

import org.w3c.dom.UserDataHandler;
import sc.ustc.dao.Conversation;

public class UserBean {
    public   UserBean(String userId,String userName,String userPass){
        this.userId=userId;
        this.userName=userName;
        this.userPass=userPass;
    }
    public   UserBean(String userId,String userName){
        this.userId=userId;
        this.userName=userName;
    }
    public   UserBean(String userId){
        this.userId=userId;
    }
    public   UserBean(){
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    private String userId;
    private String userName;
    private String userPass;
    public boolean signIn(){
        System.out.println("select userPass from user where userId = " +"'" +userId+"'");
        //UserDAO userDAO = new UserDAO("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/sqltest?serverTimezone=GMT","root","");
        //UserDAO userDAO = new UserDAO("org.sqlite.JDBC","jdbc:sqlite:C:\\Users\\whozawhat\\sqltest2.db","","");
        //UserBean userBean = (UserBean) userDAO.query("select userPass from user where username = " +"'" +userName+"'",null);
        UserBean userBean = (UserBean) UserDAO.query(this);
        System.out.println("userBean.userPass:"+userBean.userPass);
        System.out.println("this.userPass:"+this.userPass);
        if (userBean.userPass == null) {return false;}
        else if(userBean.userPass.equals(this.userPass)) {return true;}
        else return false;
    }
    public  boolean register(){
        UserBean userBean = (UserBean) UserDAO.query(this);
        if (userBean.userName != null) {return false;}
        else return UserDAO.insert(this);
    }
    public boolean logout(){
        if(UserDAO.delete(this)){return true;}
        else return false;
    }
}
