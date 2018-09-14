package com.revature;

import com.revature.Dao.UserDao;
import com.revature.Dao.ReservationDao;
import com.revature.bean.UserBean;
import com.revature.bean.ReservationBean;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();

        UserBean user = new UserBean();
        // set default user to timothy
        user.setUsername("timothy");
        user.setPassword("timothy");

        userDao.createUser(user);

        System.out.println(userDao.getUserLoginInfo(user.getUsername()));

        //setting a reservation
        ReservationDao  resdao = new ReservationDao();

        ReservationBean reserve = new ReservationBean();

       // resdao.submitReservation();


    }
}
