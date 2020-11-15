package com.example.youthwings.presenter.community;

import android.content.Context;

import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.service.CommunityService;
import com.example.youthwings.service.UserService;

public class CommunityPresenter implements CommunityConstants.Presenter {
    CommunityConstants.View communityView;
    CommunityConstants.ListView communityListView;
    CommunityService communityService;

    public CommunityPresenter(CommunityConstants.View view) {
        communityView = view;
        communityService = new CommunityService(this, communityView);
    }

    public CommunityPresenter(CommunityConstants.ListView view) {
        communityListView = view;
        communityService = new CommunityService(this, communityListView);
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
    public void onRecommend(String userId, int boardId) {
        communityService.recommend(userId, boardId);
    }
}
