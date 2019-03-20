package com.mkiisoft.wavehq.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;

public class ExpenseAccount extends RealmObject implements Serializable {

    public ExpenseAccount() {
    }

    public ExpenseAccount(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
