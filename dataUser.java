package com.example.retrofitapp.model;

import com.google.gson.annotations.SerializedName;

public class dataUser {

    @SerializedName("id")
    private int id;



    @SerializedName("employee_name")
    private String employeeName;


    public String getEmployeeName() {
        return employeeName;
    }
}
