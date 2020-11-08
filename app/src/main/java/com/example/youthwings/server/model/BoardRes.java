package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

// 서버로부터 받을 값
public class BoardRes {
    // 서버로 보낸 요청이 성공했는지 여부
    @SerializedName("suc")
    private boolean suc;

    @SerializedName("boards")
    private ArrayList<BoardModel> boardModels;

    @SerializedName("board")
    private BoardModel boardModel;

    public boolean isSuc() {
        return suc;
    }

    public ArrayList<BoardModel> getBoardModels() {
        return boardModels;
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }
}