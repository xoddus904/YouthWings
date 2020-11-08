package com.example.youthwings;

public class CommunityListViewItem {
    private int com_id;                 // 해당 게시물 고유 번호
    private String com_Title;           // 게시물 제목
    private String com_time;            // 게시물 작성 날짜
    private int com_look;               // 게시물 조회수
    private int com_recommend;          // 게시물 추천수

    public CommunityListViewItem(int com_id, String com_Title, String com_time, int com_look, int com_recommend) {
        this.com_id = com_id;
        this.com_Title = com_Title;
        this.com_time = com_time;
        this.com_look = com_look;
        this.com_recommend = com_recommend;
    }

    public int getCom_id() { return com_id; }

    public void setCom_id(int com_id) { this.com_id = com_id; }

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

    public int getCom_recommend() {
        return com_recommend;
    }

    public void setCom_recommend(int com_recommand) {
        this.com_recommend = com_recommand;
    }

}

