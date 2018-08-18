package com.revature.controller;


import com.revature.Dao.RoomDao;
import com.revature.bean.RoomBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);

        resp.setContentType("text/html charser=utf-8");
        PrintWriter pw = resp.getWriter();

        //UserBean lb = null;

        RoomDao rd = new RoomDao();
        //pw.println(rd.getRoomsAvailable());
        List<RoomBean> rooms = rd.getRoomsAvailable();

        for (RoomBean room : rooms) {
            pw.println(room.toString());
        }

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

       int rid = Integer.parseInt(req.getParameter("roomid"));
        int rnum = Integer.parseInt(req.getParameter("rnumber"));
        String rtype = req.getParameter("rtype");
        int bid = Integer.parseInt(req.getParameter("booking"));




        RoomDao rod = new RoomDao();
        RoomBean rob = new RoomBean();

        rob.setRoomid(rid);
        rob.setRoomNum(rnum);
        rob.setRoomType(rtype);
        rob.setBookingId(bid);


        //create a room
        pw.println(rod.makeRoomOccupied(rob));
    }
}
