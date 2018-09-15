package com.revature.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Dao.UserDao;
import com.revature.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
       /* resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        UserBean logingbean = new UserBean();

        UserDao dao = new UserDao();

        pw.println(dao.createUser(logingbean));*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        resp.setContentType("text/html");
        ObjectMapper mapper = new ObjectMapper();

        int  usid = Integer.parseInt(req.getParameter("userid"));
        String fulln = req.getParameter("fullName");// recevoir du client browseur
        String email = req.getParameter("email");
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String ro =    req.getParameter("role");

        PrintWriter pw = resp.getWriter();


        UserBean log = new UserBean();

        log.setUserId(usid);
        log.setFullName(fulln);// sauvegarder ca ds le bean
        log.setEmail(email);
        log.setUsername(user);
        log.setPassword(pass);
        log.setRole(ro);

        UserDao dao = new UserDao();
        pw.println(dao.createUser(log));

        pw.println("user has been created <br><br> ");
        pw.println(" ");
        pw.println("<a href =/LogoutServlet > go back to login page:</a>");


    }
}
