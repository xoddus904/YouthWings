package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class BoardModel implements Serializable {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("board_id")
    private int boardId;

    @SerializedName("board_title")
    private String boardTitle;

    @SerializedName("board_content")
    private String boardContent;

    @SerializedName("board_date")
    private Date boardDate;

    @SerializedName("board_look")
    private int boardLook;

    @SerializedName("user")
    private UserModel userModel;

    @SerializedName("likes")
    private ArrayList<LikeModel> likeModels;

    @SerializedName("replies")
    private ArrayList<ReplyModel> replyModels;

    public BoardModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public int getBoardLook() {
        return boardLook;
    }

    public void setBoardLook(int boardLook) {
        this.boardLook = boardLook;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public ArrayList<LikeModel> getLikeModels() {
        return likeModels;
    }

    public void setLikeModels(ArrayList<LikeModel> likeModels) {
        this.likeModels = likeModels;
    }

    public ArrayList<ReplyModel> getReplyModels() {
        return replyModels;
    }

    public void setReplyModels(ArrayList<ReplyModel> replyModels) {
        this.replyModels = replyModels;
    }
}

