
package com.revature.Connectivity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {

    public DbConnection() {
    }

    public static Connection getConnection() throws SQLException, IOException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@myfirstinstance.cmsawq4iwp5v.us-east-1.rds.amazonaws.com:1521:ORCL",
                "reservationDb",
                "Abouderman");
    }
}