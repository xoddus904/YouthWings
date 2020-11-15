package com.example.youthwings.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.server.model.ReplyModel;
import com.example.youthwings.util.AlertUtil;
import com.example.youthwings.util.SharedPreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommunityService {
    CommunityConstants.Presenter presenter;
    CommunityConstants.ListView communityListView;
    CommunityConstants.WritingView communityWritingView;
    CommunityConstants.View communityView;

    SharedPreferenceUtil sharedPreferenceUtil;

    public CommunityService(CommunityConstants.Presenter presenter, CommunityConstants.ListView listView) {
        this.presenter = presenter;
        this.communityListView = listView;
    }

    public CommunityService(CommunityConstants.Presenter presenter, CommunityConstants.WritingView writingView) {
        this.presenter = presenter;
        this.communityWritingView = writingView;
    }

    public CommunityService(CommunityConstants.Presenter presenter, CommunityConstants.View view) {
        this.presenter = presenter;
        this.communityView = view;
    }

    // -----------------------------------------------------------------------
    // 게시글 작성
    // -----------------------------------------------------------------------
    public void onPostBoard(Context context, String title, String content) {
        sharedPreferenceUtil = new SharedPreferenceUtil(context);
        String userId = sharedPreferenceUtil.getSharedString("userId");

        BoardModel boardModel = new BoardModel();
        boardModel.setBoardTitle(title);          // 게시글 제목
        boardModel.setBoardContent(content);      // 게시글 내용
        boardModel.setUserId(userId);             // 작성자 아이디

        Log.d("DEBUG", "################ 게시글 작성하기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).postBoard(boardModel);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();

                    communityWritingView.onRequestResult(result.isSuc());

                    Log.d("DEBUG", "################ 게시글 작성하기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 게시글 목록 가져오기
    // -----------------------------------------------------------------------
    public void getCommunityList() {
        Log.d("DEBUG", "################ 게시글 목록 가져오기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).getCommunityList();
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();

                    communityListView.onRequestResult(result.getBoardModels());      // 가져온 데이터 뿌려줌

                    Log.d("DEBUG", "################ 게시글 목록 가져오기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 커뮤니티 게시글 가져오기
    // -----------------------------------------------------------------------
    public void getCommunity(int boardId) {
        Log.d("DEBUG", "################ 게시글 가져오기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).getCommunity(boardId);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();
                    Log.d("DEBUG", result.getBoardModel().getBoardTitle());
                    Log.d("DEBUG", result.getBoardModel().getBoardDate().toString());

                    communityView.onRequestResult(result.getBoardModel());

                    Log.d("DEBUG", "################ 게시글 가져오기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 커뮤니티 추천하기
    // -----------------------------------------------------------------------
    public void recommend(Context context, int boardId) {
        sharedPreferenceUtil = new SharedPreferenceUtil(context);
        String userId = sharedPreferenceUtil.getSharedString("userId");

        BoardModel boardModel = new BoardModel();
        boardModel.setUserId(userId);               // 유저 아이디
        boardModel.setBoardId(boardId);             // 해당(추천할) 게시글 번호

        Log.d("DEBUG", "################ 게시글 추천하기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).recommendBoard(boardModel);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연결 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();
                    Log.d("DEBUG", result.isSuc() + "");

                    communityView.onRecommendResult(result.isSuc());

                    Log.d("DEBUG", "################ 게시글 추천하기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 댓글 작성
    // -----------------------------------------------------------------------
    public void onPostReply(Context context, int boardId, String content) {
        sharedPreferenceUtil = new SharedPreferenceUtil(context);
        String userId = sharedPreferenceUtil.getSharedString("userId");

        ReplyModel replyModel = new ReplyModel();
        replyModel.setReplyContent(content);    // 댓글 내용
        replyModel.setUserId(userId);           // 댓글 작성자 아이디

        Log.d("DEBUG", "################ 댓글 작성하기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).postReply(boardId, replyModel);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();
                    AlertUtil.DebugLog(result.isSuc() + "");
                    communityView.onReplyResult(result.isSuc());

                    Log.d("DEBUG", "################ 댓글 작성하기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

}
