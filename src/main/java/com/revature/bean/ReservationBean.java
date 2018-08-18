package com.revature.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationBean {

    private int bookingId;
    private String customerName;
    private Date arrivalDate;
    private int nightNo;
    private String status;

public ReservationBean(){}

    public ReservationBean(int bkid, String custN, java.util.Date arDate, int nNumber, String status){
        bookingId =bkid;
        customerName = null;
        arrivalDate = null;
        nightNo = 0;
        status=status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getNightNo() {
        return nightNo;
    }

    public void setNightNo(int nightNo) {
        this.nightNo = nightNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateToString(Date date){

        DateFormat formater;
        formater = new SimpleDateFormat("dd-MM-yy");
        String s = formater.format(date);

        return s;
    }


    @Override
    public String toString() {
        return "Reservation [" +
                "Booking Id=" + bookingId +
                ", Customer Name='" + customerName+ '\'' +
                ", Arrival Date='" + arrivalDate+ '\'' +
                ", Night Number='" + nightNo + '\'' +
                ", Status='" + status + '\'' +
                ']';
    }
}
