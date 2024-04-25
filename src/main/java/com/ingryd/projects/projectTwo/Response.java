package com.ingryd.projects.projectTwo;

import com.ingryd.projects.projectTwo.model.AccountUser;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private boolean status;
    private String message;
    private List<AccountUser> data = new ArrayList<>();

    public Response(boolean status, String message, List<AccountUser> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AccountUser> getData() {
        return data;
    }

    public void setData(List<AccountUser> data) {
        this.data = data;
    }
}
