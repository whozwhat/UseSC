package water.ustc.action;

import sc.ustc.bean.ActionBean;
import water.ustc.dao.UserBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginAction extends HttpServlet {

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private UserBean userBean;

    public String handleLogin(HttpServletRequest request, HttpServletResponse response, ActionBean actionBean) throws ServletException, IOException {

        userBean.setUserId(request.getParameter("id"));
        userBean.setUserPass(request.getParameter("password"));
        if(userBean.signIn()){return "success";}
        else return "failure";
       }
    }