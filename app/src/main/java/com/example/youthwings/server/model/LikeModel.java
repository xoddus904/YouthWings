package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class LikeModel implements Serializable {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("like_id")
    private int likeId;

    @SerializedName("board_id")
    private int boardId;

    @SerializedName("like_date")
    private Date likeDate;

    public LikeModel() {
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}

