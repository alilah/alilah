package com.revature.Dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Connectivity.DbConnection;
import com.revature.bean.ProfileBean;

import java.io.IOException;
import java.sql.*;

public class ProfileDao {

    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection conn = null;
    CallableStatement cst = null;

    ProfileBean prb = null;



    public ProfileBean showProfileById(int id){

        try ( Connection conn = DbConnection.getConnection()){

            String sql = "select * from Profile where profileId = ?";

            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();
            ObjectMapper mapper = new ObjectMapper();

            while (rst.next()){

                int prid = rst.getInt("profileId");
                String name = rst.getString("fullName");
                String email = rst.getString("email");
                String addr = rst.getString("address");
                String bill = rst.getString("billing");


                prb = new ProfileBean(prid, name, email, addr, bill);
            }


        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    return prb;
    }

//create profile, inserting personal info
    public ProfileBean createProfile(ProfileBean pb){

        try(Connection conn = DbConnection.getConnection()){

            String sql = "{CALL sp_insert_profile (?,?,?,?,?)}";//does not add to db

            cst = conn.prepareCall(sql);

            cst.setInt(1,pb.getProfileid());
            cst.setString(2,pb.getFullName());
            cst.setString(3,pb.getEmail());
            cst.setString(4,pb.getAddress());
            cst.setString(5,pb.getBilling());

            pb = new ProfileBean(pb.getProfileid(),pb.getFullName(),pb.getEmail(),pb.getAddress(),pb.getBilling());

            int x = cst.executeUpdate();
            if(x == 1 ){ System.out.println("row inserted");}

            // System.out.println(" info for user ID: " + lb.getUserId());
            System.out.println(" your data has been inserted into profile table ");


        }catch (SQLException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return pb;
    }

// update profile, changing some fields values
    public boolean updateProfile(ProfileBean profile){


        try ( Connection conn = DbConnection.getConnection()){

            String sql = "update Profile set fullname = ?, email=?, address=?, billing=?  where profileId = ?";

            pst = conn.prepareStatement(sql);



                pst.setString(1,profile.getFullName());
                pst.setString(2,profile.getEmail());
                pst.setString(3,profile.getAddress());
                pst.setString(4,profile.getBilling());
                pst.setInt(5,profile.getProfileid());

                profile = new ProfileBean(profile.getProfileid(),profile.getFullName(),profile.getEmail(),profile.getAddress(),profile.getBilling());


            int i = pst.executeUpdate();

                if(i == 1){
                    System.out.println(""+ profile);
                    System.out.println("profile updated ");
                    return true;
                }


        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return false;
    }
}
