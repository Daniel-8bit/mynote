package com.example.ideademo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        UserController user = new UserController();

        if(username.equals("root") && pwd.equals("123")){
            user.setGender("男");
            user.setId("1223");
            user.setName("wsj");
            user.setLocation("yitali");
            req.getSession().setAttribute("loginUser", user);
            req.getRequestDispatcher("/user.jsp").forward(req,resp);

        }else{
            req.setAttribute("msg","账号密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

}
