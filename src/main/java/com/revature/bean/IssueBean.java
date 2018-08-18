package com.revature.bean;




public class IssueBean {

    private int issueId;
    private  String details;
    private String status;

    public IssueBean(){}


    public IssueBean(int issid, String desc,String status){
        this.issueId=issid;
        this.details = desc;
        this.status= status;

    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Issue: {" +
                "issueId=" + issueId +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
