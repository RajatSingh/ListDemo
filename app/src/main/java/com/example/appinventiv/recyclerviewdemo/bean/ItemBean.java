package com.example.appinventiv.recyclerviewdemo.bean;

import java.io.Serializable;

/**
 * Created by appinventiv on 21/7/15.
 */
public class ItemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String emailId;

    private boolean isSelected;



    public ItemBean() {

    }

    public ItemBean(String name, String emailId) {

        this.name = name;
        this.emailId = emailId;

    }

    public ItemBean(String name, String emailId, boolean isSelected) {

        this.name = name;
        this.emailId = emailId;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}


