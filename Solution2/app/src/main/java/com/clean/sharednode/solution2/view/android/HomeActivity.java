package com.clean.sharednode.solution2.view.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.clean.sharednode.solution2.R;
import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;
import com.clean.sharednode.solution2.presenters.HomePresenter;
import com.clean.sharednode.solution2.view.IHomeView;

import java.util.List;


public class HomeActivity extends AppCompatActivity implements IHomeView {

    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new HomePresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.loadPost(1);
    }

    @Override
    public void onPostLoaded(Post post) {
        Toast.makeText(HomeActivity.this,post.getBody(),Toast.LENGTH_SHORT).show();
        mPresenter.loadComments(post.getId());
    }

    @Override
    public void onCommentsLoaded(List<Comment> comments) {
        Toast.makeText(HomeActivity.this,"total comments="+comments.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        //TODO handle error
    }
}
