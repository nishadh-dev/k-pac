package com.aurosks.models;

import java.util.List;

public class Set {
    private int id;
    private String title;
    private List<Integer> kPacIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getkPacIds() {
        return kPacIds;
    }

    public void setkPacIds(List<Integer> kPacIds) {
        this.kPacIds = kPacIds;
    }
}
