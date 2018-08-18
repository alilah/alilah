package com.revature.Dao;


import com.revature.Connectivity.DbConnection;
import com.revature.bean.ReservationBean;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;

public class ReservationDao {

    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection connect = null;
    CallableStatement cst = null;
    Date sqlDate = null;

    List<ReservationBean> resbean = new ArrayList();

//view all reservation either approved or deny (only the guest)
    public ReservationBean getReservation(String status) {
        ReservationBean rsb = null;

        try (Connection connect = DbConnection.getConnection()) {

            String sql = "select * from Reservation where status = ?";

            pst = connect.prepareStatement(sql);
            pst.setString(1,status);
            rst = pst.executeQuery();

            while(rst.next()){
                int bo_id = rst.getInt("bookingId");
                String CustN = rst.getString("customerName");
                Date arDate = rst.getDate("Date");
                int nNumber = rst.getInt("nightN");
                //String status = rst.getString("status");


                rsb =  new ReservationBean(bo_id,CustN, arDate, nNumber, status);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return rsb;
    }

// a guest can submit a reservation by setting it
    public ReservationBean submitReservation(ReservationBean rsb) {

        try (Connection connect = DbConnection.getConnection()){

            String sql = "{call sp_insert_reservation (?, ?, ?, ?,?)}";

            cst = connect.prepareCall(sql);

            cst.setInt(1,rsb.getBookingId());
            cst.setString(2,rsb.getCustomerName());
            sqlDate = new java.sql.Date(rsb.getArrivalDate().getTime());// convert to sql date
            cst.setDate(3, sqlDate);
            cst.setInt(4,rsb.getNightNo());
            cst.setString(5,rsb.getStatus());

            int y = cst.executeUpdate();

            rsb = new ReservationBean(rsb.getBookingId(),rsb.getCustomerName(),rsb.getArrivalDate(),rsb.getNightNo(),rsb.getStatus());


            if(y== 1){ System.out.println("row inserted");}

            System.out.println(" reservation has been created");


        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return rsb;
        }

// a host can approve or deny a reservation
    public ReservationBean updateReservation ( int bid){
                ReservationBean update = null;

                try (Connection connect = DbConnection.getConnection()) {

                    String sql = "{call updateReservation(?, ?)}";

                    cst = connect.prepareCall(sql);

                    cst.setInt(1, update.getBookingId());
                    cst.setString(2, update.getStatus());

                    cst.executeQuery();


                    update = new ReservationBean();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return update;
            }

}