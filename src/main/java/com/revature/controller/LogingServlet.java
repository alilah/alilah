package com.revature.controller;

import com.revature.Connectivity.DbConnection;
import com.revature.Dao.UserDao;
import com.revature.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LogingServlet")
public class LogingServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);//in case you put the path /LogingServlet in the address bar
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        UserDao dao = new UserDao();

       /* List<UserBean> users = dao.getAllguests();

        for (UserBean user : users) {
            pw.println( );
            pw.println(user.toString());
        }*/
       // instead of creating a dao
        pw.print("<html>");
        pw.print("<head><title>All Guests </title></head>");
        pw.print("</body>");
        pw.print("<center>");

        PreparedStatement pst = null;
        CallableStatement cst = null;


        List<UserBean> guests = null ;

        UserBean lb = null;


        try(Connection conn = DbConnection.getConnection()) {

            guests  = new ArrayList<UserBean>();

            String sql = "SELECT * FROM USERS";

            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pw.println("All Guest in the hotel! ");
            pw.print("<table><tr>" +
                    "<th> userid </th>" +
                    "<th> name </th> " +
                    " <th> email </th>" +
                    " <th> username " +
                    " <th> password </th>" +
                    " <th> role </th></tr></table>");
            while(rs.next()) {

                int userid = rs.getInt("USERID");
                String name = rs.getString("FullNAME");
                String email = rs.getString("EMAIL");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWE");
                String role = rs.getString("rolee");
                pw.print("<table><tr>");
                pw.print("<th>"+ userid + " </th> ");
                pw.print("<th>" +name + " </th> ");
                pw.print("<th>" +email + " </th> ");
                pw.print("<th>" +username + " </th> ");
                pw.print("<th>" +password + " </th> ");
                pw.print("<th>" +role + " </th> ");
                pw.print("");
                pw.print("</tr></table>");

                    /*lb = new UserBean(uid, name, ema,user, pass,  r);

                    guests.add(lb);*/

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        pw.print("</center>");
        pw.println("</body>");
        pw.println("</html>");

        pw.close();



    }

        protected void doPost (HttpServletRequest request, HttpServletResponse response)throws
        ServletException, IOException {


            response.setContentType("text/html charset=utf-8");
            PrintWriter pw = response.getWriter();

            String username = request.getParameter("username");//ce qui est en guillemet(paranthese) est ce que je recois du client
            String password = request.getParameter("password");

            UserBean logingbean = new UserBean();

            logingbean.setUsername(username);
            logingbean.setPassword(password);


            UserDao dao = new UserDao();


            try {

                String userValidation = dao.authenticateUser(logingbean);

                //was userValidation
                switch (userValidation) {
                    case "Host's Role": {

                        HttpSession session = request.getSession();
                        session.setAttribute("Host", username);//garder les info du client ds une session
                        request.setAttribute("username", username);

                        request.getRequestDispatcher("Host.html").forward(request, response);


                        break;
                    }
                    case "User's Role": {

                        HttpSession session = request.getSession();
                        session.setAttribute("User", username);
                        request.setAttribute("username", username);

                        request.getRequestDispatcher("User.html").forward(request, response);
                        break;
                    }
                    default:
                        pw.println("Error Message:  " + userValidation);
                        request.setAttribute("error message", userValidation);

                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("username " + username);


            System.out.println("password " + password);

            // if host want to see a guest info
            //pw.println(dao.getUserLoginInfo(username));//this works

            //if host want to create/register a guest
            pw.println(dao.createUser(logingbean));//not working now


        }


    }