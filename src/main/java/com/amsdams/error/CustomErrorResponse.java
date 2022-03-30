package com.amsdams.error;

public class CustomErrorResponse {

    
    private int status;
    private String message;

    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String error) {
        this.message = error;
    }
}
