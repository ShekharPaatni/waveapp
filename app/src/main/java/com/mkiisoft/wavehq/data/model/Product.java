package com.mkiisoft.wavehq.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmObject;

public class Product extends RealmObject implements Serializable {

    public Product() {
    }

    public Product(Integer id, String url, String name, Integer price, String description, Boolean isSold, Boolean isBought, IncomeAccount incomeAccount, ExpenseAccount expenseAccount, Boolean active, String dateCreated, String dateModified) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isSold = isSold;
        this.isBought = isBought;
        this.incomeAccount = incomeAccount;
        this.expenseAccount = expenseAccount;
        this.active = active;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private Integer price;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("is_sold")
    @Expose
    private Boolean isSold;

    @SerializedName("is_bought")
    @Expose
    private Boolean isBought;

    @SerializedName("income_account")
    @Expose
    private IncomeAccount incomeAccount;

    @SerializedName("expense_account")
    @Expose
    private ExpenseAccount expenseAccount;

    @SerializedName("active")
    @Expose
    private Boolean active;

    @SerializedName("date_created")
    @Expose
    private String dateCreated;

    @SerializedName("date_modified")
    @Expose
    private String dateModified;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public Boolean getBought() {
        return isBought;
    }

    public void setBought(Boolean bought) {
        isBought = bought;
    }

    public IncomeAccount getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(IncomeAccount incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public ExpenseAccount getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(ExpenseAccount expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
