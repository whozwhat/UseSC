package water.ustc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginAction extends HttpServlet {

    public  String handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            return "success";
        }
    }