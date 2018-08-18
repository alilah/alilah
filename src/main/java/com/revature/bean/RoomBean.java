package com.revature.bean;




public class RoomBean {
    private int roomid;
    private int roomNum;
    private String roomType;
    private int bookingId;


    public RoomBean(){}


    public RoomBean(int roomid, int roomN, String roomT, int bkid){
        this.roomid = roomid;
        this.roomNum = roomN;
        this.roomType = roomT;
        this.bookingId=bkid;

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNum() {

        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }


    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "RoomBean [roomId=" + roomid + ", roomNumber=" + roomNum + ", roomType=" + roomType  + ", bookingId=" + bookingId  +"]";
    }

}
