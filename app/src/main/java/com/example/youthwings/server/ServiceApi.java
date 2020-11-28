package com.example.youthwings.server;

import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.server.model.LoanRes;
import com.example.youthwings.server.model.ReplyModel;
import com.example.youthwings.server.model.UserModel;
import com.example.youthwings.server.model.UserRes;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

// ***************************************
// 서버 API 목록입니다.
// ***************************************
public interface ServiceApi {
// ===================================================================================

    // ***************************************
    // 사용자 목록
    // ***************************************

    // 로그인
    @POST("/account/login")
    Call<UserRes> signIn(@Body UserModel userModel);

    // 회원 가입
    @POST("/account")
    Call<UserRes> signUp(@Body UserModel userModel);

    // 닉네임 생성
    @GET("/account/nickname")
    Call<UserRes> getNickName();

// ===================================================================================

    // ***************************************
    // 커뮤니티 목록
    // ***************************************

    // 게시글 목록 가져오기
    @GET("/board")
    Call<BoardRes> getCommunityList();

    // 게시글 가져오기
    @GET("/board/{id}")
    Call<BoardRes> getCommunity(@Path("id") int boardId);

    // 게시글 추천하기
    @POST("/board/like")
    Call<BoardRes> recommendBoard(@Body BoardModel boardModel);

    // 게시글 작성
    @POST("/board")
    Call<BoardRes> postBoard(@Body BoardModel boardModel);

    // 댓글 작성
    @POST("/board/{id}/reply")
    Call<BoardRes> postReply(@Path("id") int boardId, @Body ReplyModel replyModel);

    // 댓글 삭제
    @DELETE("/board/reply/{reply_id}")
    Call<BoardRes> delReply(@Path("reply_id") int replyId);

    // 댓글 수정
    @PATCH("/board/reply/{reply_id}")
    Call<BoardRes> updateReply(@Path("reply_id") int replyId, @Body ReplyModel replyModel);

// ===================================================================================

    // ***************************************
    // 예약 목록
    // ***************************************

    // 예약 목록 가져오기
    @GET("/rental/{id}")
    Call<LoanRes> getLoanList(@Path("id") String userId);

    // 예약 하기
    @POST("/rental")
    Call<LoanRes> postLoan(@Body LoanModel loanModel);

}