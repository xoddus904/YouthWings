package com.example.youthwings.presenter.community;

import android.content.Context;

import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.service.CommunityService;
import com.example.youthwings.service.UserService;

public class CommunityPresenter implements CommunityConstants.Presenter {
    CommunityConstants.View communityView;
    CommunityConstants.ListView communityListView;
    CommunityConstants.WritingView communityWritingView;
    CommunityService communityService;

    public CommunityPresenter(CommunityConstants.View view) {
        communityView = view;
        communityService = new CommunityService(this, communityView);
    }

    public CommunityPresenter(CommunityConstants.ListView view) {
        communityListView = view;
        communityService = new CommunityService(this, communityListView);
    }

    public CommunityPresenter(CommunityConstants.WritingView view) {
        communityWritingView = view;
        communityService = new CommunityService(this, communityWritingView);
    }

    @Override
    public void onPostBoard(Context context, String title, String content) {
        communityService.onPostBoard(context, title, content);
    }

    @Override
    public void onGetCommunityList() {
        communityService.getCommunityList();
    }

    @Override
    public void onGetCommunity(int boardId) {
        communityService.getCommunity(boardId);
    }

    @Override
    public void onRecommend(Context context, int boardId) {
        communityService.recommend(context, boardId);
    }

    @Override
    public void onPostReply(Context context, int boardId, String content) {
        communityService.onPostReply(context, boardId, content);
    }

    @Override
    public void onDeleteReply(int replyId) {
        communityService.onDeleteReply(replyId);
    }
}
