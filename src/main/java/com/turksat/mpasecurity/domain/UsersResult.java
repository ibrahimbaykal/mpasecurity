package com.turksat.mpasecurity.domain;

import java.util.List;

public class UsersResult {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
