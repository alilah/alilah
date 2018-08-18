package com.revature.bean;

public class Email {


    private int emailId;
    private String messageReceived;
    private String sentMessage;



    public Email(){}

    public Email(int  email, String msg, String sent){
        this.emailId=email;
        this.messageReceived=msg;
        this.sentMessage=sent;
    }


    public String getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public String getMessageReceived() {
        return messageReceived;
    }

    public void setMessageReceived(String messageReceived) {
        this.messageReceived = messageReceived;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
}


