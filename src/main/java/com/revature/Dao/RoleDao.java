package com.revature.Dao;


import com.revature.bean.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDao {

    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection conn = null;
    Role role;


    Role getRoleById(int id) throws SQLException {


            String sql ="select * from Role where id = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rst = pst.executeQuery();

           while(rst.next()){
               // int id = rst.getInt("id");
                String ro =rst.getString("role");
                role = new Role(id, ro);

            }
        /*Role role;

        if (rst.getString("Rolee") == "USER") {
            //role = Role.GUEST;
             role = new Role(2, "Guest");
        } else {
            //role = Role.HOST;
             role = new Role(1, "Host");
        }*/
            return  role;
    }


}
