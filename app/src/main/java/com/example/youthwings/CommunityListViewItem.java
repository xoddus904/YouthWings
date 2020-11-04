package com.example.youthwings;

public class CommunityListViewItem {
    private String com_Title;
    private String com_time;
    private int com_look;
    private int com_recommand;

    public CommunityListViewItem(String com_Title, String com_time, int com_look, int com_recommand) {
        this.com_Title = com_Title;
        this.com_time = com_time;
        this.com_look = com_look;
        this.com_recommand = com_recommand;
    }


    public String getCom_Title() {
        return com_Title;
    }

    public void setCom_Title(String com_Title) {
        this.com_Title = com_Title;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    public int getCom_look() {
        return com_look;
    }

    public void setCom_look(int com_look) {
        this.com_look = com_look;
    }

    public int getCom_recommand() {
        return com_recommand;
    }

    public void setCom_recommand(int com_recommand) {
        this.com_recommand = com_recommand;
    }

}

