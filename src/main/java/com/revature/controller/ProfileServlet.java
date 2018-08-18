package com.revature.controller;


import com.revature.Dao.ProfileDao;
import com.revature.bean.ProfileBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        ProfileBean pb = new ProfileBean();
        ProfileDao pd = new ProfileDao();

       // pw.println( pd.showProfileById(2));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
       /* resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        HttpSession session = req.getSession();
       // String ui = (String) session.getAttribute("username");

        ObjectMapper map = new ObjectMapper();
        System.out.println(" Profile updating ");

        ProfileBean pb = new ProfileBean();
        ProfileDao prod = new ProfileDao();

        pb = map.readValue(req.getInputStream(),ProfileBean.class);
       // pw.println(prod.createProfile(pb).toString());

        pw.println(pb.toString());*/


       resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        int pr = Integer.parseInt(req.getParameter("profile"));
        String name = req.getParameter("fullName");
        String email = req.getParameter("email");
        String add = req.getParameter("address");
        String bil = req.getParameter("bill");


        ProfileDao prod = new ProfileDao();

        ProfileBean pb = new ProfileBean();

        pb.setProfileid(pr);
        pb.setFullName(name);
        pb.setEmail(email); // sauvegarder ce que tu lis de la forme ds les donnees
        pb.setAddress(add);
        pb.setBilling(bil);

       // pw.println(prod.updateProfile(pb));
        pw.println(prod.createProfile(pb));


    }
}
