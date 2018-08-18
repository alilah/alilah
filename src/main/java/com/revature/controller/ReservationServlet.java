package com.revature.controller;


import com.revature.Dao.ReservationDao;
import com.revature.bean.ReservationBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        ReservationDao res = new ReservationDao();
        ReservationBean rsb = new ReservationBean();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);


        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
       // ObjectMapper mapper = new ObjectMapper();

        ReservationDao res = new ReservationDao();
        ReservationBean rsb = new ReservationBean();
        //rsb = mapper.readValue(req.getInputStream(),ReservationBean.class);

        DateFormat formater = new SimpleDateFormat("dd-MM-yy");
        Date d = null;
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String date = day+ "-"+month+"-"+year;

        try{
            d= (Date)formater.parse(date);
        }catch (ParseException p){
            p.printStackTrace();
        }

        int bid = Integer.parseInt(req.getParameter("booking"));
        String name = req.getParameter("name");
       // Date date = (req.getParameter("arrival"));
        int night = Integer.parseInt(req.getParameter("nights"));
        String status = req.getParameter("status");


        rsb.setBookingId(bid);
        rsb.setCustomerName(name);
        rsb.setArrivalDate(d);
        rsb.setNightNo(night);
        rsb.setStatus(status);


        pw.println(res.submitReservation(rsb));


    }
}
