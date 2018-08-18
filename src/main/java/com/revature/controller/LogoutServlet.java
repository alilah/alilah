package com.revature.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(req, resp);


        HttpSession session = request.getSession(false);

        if(session !=null){//if session not null

            session.invalidate();// remove all session attribute bond to that user

            request.setAttribute("errMessage", "your are logged out successfully");
            RequestDispatcher reqD = request.getRequestDispatcher("./index.html"); //send user again to login
            reqD.forward(request,response);
            System.out.println("you are logged out");

        }
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}
