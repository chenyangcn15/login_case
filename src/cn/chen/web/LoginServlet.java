package cn.chen.web;

import cn.chen.dao.UserDao;
import cn.chen.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost.......................................................");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet.......................................................");

        // 1. set encoding method
        request.setCharacterEncoding("utf-8");
        // 2. get parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // 3. wrap user object
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        
        // 4. call UserDao login method
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        // 5. check the result
        if(user == null)
        {
            //fail
            //redirect
            request.getRequestDispatcher("/failServlet").forward(request, response);
            System.out.println("fail..........................");
        } else
        {
            //success
            //store data
            System.out.println("success..........................");
            request.setAttribute("user", user);
            //redirect
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }
}
