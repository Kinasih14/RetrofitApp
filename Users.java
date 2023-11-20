package com.example.retrofitapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Users {
        public List<dataUser> getData() {
                return data;
        }

        @SerializedName("data")
        private List<dataUser> data;
}
