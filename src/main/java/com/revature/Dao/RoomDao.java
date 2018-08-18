package com.revature.Dao;


import com.revature.Connectivity.DbConnection;
import com.revature.bean.RoomBean;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {

    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection conn = null;
    RoomBean rb = null;
    CallableStatement cst =null;


    public RoomBean getRoomAvailability(int rid){


        try(Connection conn = DbConnection.getConnection()){

            String sql = "select * from Room where roomId = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1,rid);
            rst = pst.executeQuery();


            while(rst.next()){
                int roomNum = rst.getInt("roomNumber");
                String rType = rst.getString("roomType");
                int bid = rst.getInt("bookingId");



                rb = new RoomBean(rid,roomNum,rType ,bid);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return rb;

    }

    public RoomBean makeRoomOccupied(RoomBean rob){


        try(Connection conn = DbConnection.getConnection()){

            String sql = "{call sp_make_room_occupied (?,?,?,?)}";

            cst = conn.prepareCall(sql);



            cst.setInt(1,rob.getRoomid());
            cst.setInt(2,rob.getRoomNum());
            cst.setString(3,rob.getRoomType());
            cst.setInt(4,rob.getBookingId());


            rob = new RoomBean(rob.getRoomid(),rob.getRoomNum(),rob.getRoomType(),rob.getBookingId());
            cst.executeUpdate();
            System.out.println(" your data has been inserted into room table ");



        }catch(SQLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return rob;

    }

    public List<RoomBean> getRoomsAvailable(){

        RoomBean rbe = null;

        List<RoomBean> rooms = new ArrayList<>();


        try(Connection conn = DbConnection.getConnection()){

            String sql = "select * from Room ";

            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();


            while(rst.next()){
                int rid = rst.getInt("roomId");
                int roomNum = rst.getInt("roomNumber");
                String rType = rst.getString("roomType");
                int bid = rst.getInt("bookingId");



                rbe = new RoomBean(rid,roomNum,rType,bid);
                rooms.add(rbe);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return rooms;

    }

}
