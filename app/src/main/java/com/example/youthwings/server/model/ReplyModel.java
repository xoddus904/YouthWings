package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class ReplyModel implements Serializable {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("board_id")
    private int board_id;

    @SerializedName("reply_id")
    private int replyId;

    @SerializedName("reply_content")
    private String replyContent;

    @SerializedName("reply_date")
    private Date replyDate;

    public ReplyModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
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
}

