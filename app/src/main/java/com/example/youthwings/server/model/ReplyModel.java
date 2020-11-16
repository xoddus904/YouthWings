package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class ReplyModel implements Serializable {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("board_id")
    private int boardId;

    @SerializedName("reply_id")
    private int replyId;

    @SerializedName("reply_content")
    private String replyContent;

    @SerializedName("reply_date")
    private Date replyDate;

    @SerializedName("user")
    private UserModel userModel;


    public ReplyModel() {
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

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}

