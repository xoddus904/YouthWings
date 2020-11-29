package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.youthwings.adapter.CommunityReplyAdapter;
import com.example.youthwings.adapter.LoanListAdapter;
import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.community.CommunityPresenter;
import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.server.model.ReplyModel;
import com.example.youthwings.util.AlertUtil;
import com.example.youthwings.util.SharedPreferenceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommunityActivity2 extends AppCompatActivity implements CommunityConstants.View {
    private Intent intent;
    private SharedPreferenceUtil sharedPreferenceUtil;

    private Toolbar toolbar;
    private EditText reply_editText;            // 댓글 EditText
    private TextView title_detail_textView,     // 제목 TextView
            content_detail_textView,            // 내용 TextView
            date_detail_textView,               // 날짜 TextView
            recommend_detail_textView,          // 추천 수 TextView
            look_detail_textView,               // 조회 수 TextView
            none_textView,                      // 댓글 내용 없을 때 TextView
            name_textView;                      // 닉네임 TextView
    private ListView listView;                  // 댓글 리스트뷰

    public int boardId;                // 해당 게시글 번호
    private String userId;              // 사용자 아이디
    private int recommend;              // 해당 게시글 추천 갯수

    public CommunityConstants.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community2);
        presenter = new CommunityPresenter(this);
        initLayout();
        initData();

        presenter.onGetCommunity(boardId); // 게시글 가져오기
    }

    private void initData() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        intent = getIntent();       // 이전 액티비티에서 값 가져오기
        boardId = intent.getIntExtra("boardId", 0);        // 게시글 번호 세팅
        userId = sharedPreferenceUtil.getSharedString("userId");        // 사용자 아이디 세팅
    }

    private void initLayout() {
        listView = findViewById(R.id.com_reply_list);
        reply_editText = findViewById(R.id.com_reply_content);
        title_detail_textView = findViewById(R.id.com_title_detail);
        content_detail_textView = findViewById(R.id.com_content_detail);
        date_detail_textView = findViewById(R.id.com_date_detail);
        recommend_detail_textView = findViewById(R.id.com_recommend_datail);
        look_detail_textView = findViewById(R.id.com_look_detail);
        none_textView = findViewById(R.id.com_reply_none);
        name_textView = findViewById(R.id.com_name_detail);

        // =============================================================
        // 툴바관리
        // =============================================================
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");                         // 액션바 타이틀은 없애기
        TextView toolbarTitle = findViewById(R.id.toolbar_title);   // 만든 툴바의 textview를 변경
        toolbarTitle.setText("취업 커뮤니티");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      // 뒤로가기 버튼
    }

    // =============================================================
    // 커뮤니티 게시글 뿌려주기
    // =============================================================
    private void setTextView(BoardModel boardModel) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");     // 날짜 형식 변환
        recommend = boardModel.getLikeModels().size();                                  // 해당 게시글 좋아요 갯수

        title_detail_textView.setText(boardModel.getBoardTitle());
        content_detail_textView.setText(boardModel.getBoardContent());
        date_detail_textView.setText(format.format(boardModel.getBoardDate()));
        recommend_detail_textView.setText(String.valueOf(recommend));
        look_detail_textView.setText(String.valueOf(boardModel.getBoardLook()));
        name_textView.setText(boardModel.getUserModel().getNickName());
    }

    // =============================================================
    // 커뮤니티 댓글 뿌려주기
    // =============================================================
    private void setReplyList(ArrayList<ReplyModel> replyModels) {
        // 댓글이 없는 경우
        if (replyModels.size() <= 0) {
            listView.setVisibility(View.GONE);
            none_textView.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.VISIBLE);
            none_textView.setVisibility(View.GONE);
        }

        CommunityReplyAdapter adapter = new CommunityReplyAdapter(this, replyModels, boardId);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
    }

    // =============================================================
    // 댓글 리스트뷰 길이 늘리기
    // =============================================================
    public void setListViewHeightBasedOnChildren(ListView listView) {
        CommunityReplyAdapter listAdapter = (CommunityReplyAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recommend_plus:
                presenter.onRecommend(this, boardId);
                break;
            case R.id.com_reply_btn:
                String replyContent = reply_editText.getText().toString();
                AlertUtil.DebugLog(replyContent);
                // 댓글 내용이 없으면
                if (replyContent.trim().isEmpty()) {
                    AlertUtil.onAlertDialog(this, "댓글 내용을 입력해주세요.");
                    return;
                }

                presenter.onPostReply(this, boardId, replyContent);
                break;
        }
    }

    //툴바
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestResult(BoardModel result) {
        setTextView(result);
        setReplyList(result.getReplyModels());
    }

    @Override
    public void onRecommendResult(boolean result) {
        if (result) {
            AlertUtil.onAlertDialog(this, "추천되었습니다!");
            recommend++;
        } else {
            AlertUtil.onAlertDialog(this, "취소되었습니다.");
            recommend--;
        }
        recommend_detail_textView.setText(String.valueOf(recommend));
    }

    @Override
    public void onReplyResult(boolean result) {
        if (result) {
            AlertUtil.onAlertDialog(this, "댓글이 작성되었습니다.");
            reply_editText.setText("");

            // 키보드 내리기
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(reply_editText.getWindowToken(), 0);
        } else {
            AlertUtil.onAlertDialog(this, "잠시 후 다시 시도해주십시오.");
        }
        presenter.onGetCommunity(boardId);
    }
}