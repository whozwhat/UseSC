package water.ustc.action;

import sc.ustc.bean.ActionBean;
import water.ustc.dao.UserBean;
import water.ustc.dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet {

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private UserBean userBean;

    public  String handleLogout(HttpServletRequest request, HttpServletResponse response, ActionBean actionBean) throws ServletException, IOException {
        userBean.setUserId(request.getParameter("id"));
        if(UserDAO.delete(userBean)) {
            return "success";
        }else return "failure";
    }
}