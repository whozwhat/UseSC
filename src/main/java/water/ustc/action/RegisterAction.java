package water.ustc.action;

import sc.ustc.bean.ActionBean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegisterAction extends HttpServlet {

    public  String handleRegist(HttpServletRequest request, HttpServletResponse response, ActionBean actionBean) throws ServletException, IOException {
            return "success";
        }
    }