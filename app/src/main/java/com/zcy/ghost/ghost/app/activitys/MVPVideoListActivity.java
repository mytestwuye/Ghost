package com.zcy.ghost.ghost.app.activitys;

import android.os.Bundle;

import com.zcy.ghost.ghost.R;
import com.zcy.ghost.ghost.app.BaseActivity;
import com.zcy.ghost.ghost.presenter.VideoListTaskPresenter;
import com.zcy.ghost.ghost.viewinterface.VideoListTaskView;

public class MVPVideoListActivity extends BaseActivity {
    VideoListTaskView mAddEditTaskView;
    VideoListTaskPresenter mPresenter;
    String mTitle = "";
    String mCatalogId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        mAddEditTaskView = (VideoListTaskView) findViewById(R.id.list_task_view);
        getIntentData();
        mPresenter = new VideoListTaskPresenter(mAddEditTaskView, mCatalogId);
        mPresenter.onRefresh();
    }

    private void getIntentData() {
        mCatalogId = getIntent().getStringExtra("catalogId");
        mTitle = getIntent().getStringExtra("title");
        mAddEditTaskView.setTitleName(mTitle);
    }
}