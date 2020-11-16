package com.example.youthwings.presenter;

import android.content.Context;

import com.example.youthwings.server.model.BoardModel;

import java.util.ArrayList;

public interface CommunityConstants {
    interface ListView {
        // 커뮤니티 목록 조회 결과
        void onRequestResult(ArrayList<BoardModel> result);
    }

    interface View {
        // 커뮤니티 조회 결과
        void onRequestResult(BoardModel result);

        // 커뮤니티 추천 결과
        void onRecommendResult(boolean result);

        // 댓글 작성 결과
        void onReplyResult(boolean result);
    }

    interface WritingView{
        // 게시글 작성 결과
        void onRequestResult(boolean result);

    }


    interface Presenter {
        // ---------------------------------------------------
        // 게시글 작성하기
        // ---------------------------------------------------
        void onPostBoard(Context context, String title, String content);

        // ---------------------------------------------------
        // 커뮤니티 목록 가져오기
        // ---------------------------------------------------
        void onGetCommunityList();

        // ---------------------------------------------------
        // 커뮤니티 가져오기
        // ---------------------------------------------------
        void onGetCommunity(int boardId);

        // ---------------------------------------------------
        // 커뮤니티 추천하기
        // ---------------------------------------------------
        void onRecommend(Context context, int boardId);

        // ---------------------------------------------------
        // 댓글 작성하기
        // ---------------------------------------------------
        void onPostReply(Context context, int boardId, String content);

        // ---------------------------------------------------
        // 댓글 삭제하기
        // ---------------------------------------------------
        void onDeleteReply(int replyId);
    }
}
