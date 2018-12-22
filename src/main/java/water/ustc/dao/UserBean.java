package water.ustc.dao;

import org.w3c.dom.UserDataHandler;

public class UserBean {
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
        System.out.println("select userPass from user where username = " +"'" +userName+"'");
        UserDAO userDAO = new UserDAO("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/sqltest?serverTimezone=GMT","root","");
        UserBean userBean = (UserBean) userDAO.query("select userPass from user where username = " +"'" +userName+"'",null);
        System.out.println("userBean.userPass:"+userBean.userPass);
        System.out.println("this.userPass:"+this.userPass);
        if (userBean.userPass == null) {return false;}
        else if(userBean.userPass.equals(this.userPass)) {return true;}
        else return false;
    }
}
