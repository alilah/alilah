package com.revature.controller;

import com.revature.Dao.IssueDao;
import com.revature.bean.IssueBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        IssueDao idao = new IssueDao();

        pw.println(idao.getAllIssues());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        //raise an issue
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        int issueid = Integer.parseInt(req.getParameter("issueid"));// recevoir du client browseur
        String description = req.getParameter("description");
        String status = req.getParameter("status");

        IssueBean isb = new IssueBean();
        isb.setIssueId(issueid);
        isb.setDetails(description);
        isb.setStatus(status);


        IssueDao isd = new IssueDao();
        //pw.println(isd.getIssueStatus(21));

        //if guest want to raise issue
        pw.println(isd.createIssue(isb));
        pw.println(" ");
        pw.println("<a href =/LogoutServlet > go back to login page:</a>");



    }
}
