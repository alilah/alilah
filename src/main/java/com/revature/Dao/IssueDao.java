package com.revature.Dao;


import com.revature.Connectivity.DbConnection;
import com.revature.bean.IssueBean;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssueDao {

    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rst = null;
    CallableStatement cst = null;


    IssueBean ib = null;

//from the guest standpoint (a procedure)
    public IssueBean getIssueStatus(int id){


        try(Connection conn = DbConnection.getConnection()){
            String sql = "select * from Issues where issueId = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rst = pst.executeQuery();

            while(rst.next()){
                String details = rst.getString("descriptDetails");
                String status = rst.getString("status");


                ib = new IssueBean(id,details,status);
            }



        }catch(SQLException e){
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return ib;
    }

//create or raise issue with the host
    public IssueBean createIssue(IssueBean isb){

        try(Connection conn = DbConnection.getConnection()){

            String sql = "{call sp_insert_issues(?,?,?)}";

            cst = conn.prepareCall(sql);
            //pst.setInt(1,id);

            cst.setInt(1,isb.getIssueId());
            cst.setString(2,isb.getDetails());
            cst.setString(3,isb.getStatus());

            cst.executeUpdate();

            isb = new IssueBean(isb.getIssueId(),isb.getDetails(),isb.getStatus());

                System.out.println(" your data has been inserted ");


        }catch(SQLException e){
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return isb;
    }

// get all issues from the hotel
    public List<IssueBean> getAllIssues() {


        List<IssueBean> issues = new ArrayList<IssueBean>();
        IssueBean issue = null;

        try (Connection conn = DbConnection.getConnection()) {

            String sql = "select * from Issues where status = 'pending'";

            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();

            while (rst.next()) {

                int isd = rst.getInt("issueid");
                String details = rst.getString("descriptDetails");
                String status = rst.getString("status");


                issue = new IssueBean(isd, details, status);
                issues.add(issue);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return issues;
    }

}
