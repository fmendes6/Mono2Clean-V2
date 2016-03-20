package com.clean.sharednode.solution2.presenters;

import com.clean.sharednode.solution2.model.IPostsModel;
import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;
import com.clean.sharednode.solution2.model.local.PostInMemoryModel;
import com.clean.sharednode.solution2.model.remote.PostRetrofitModel;
import com.clean.sharednode.solution2.view.IHomeView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


public class HomePresenter {

    private IHomeView mView;
    private IPostsModel mRemote, mLocal;

    public HomePresenter(IHomeView view) {
        mRemote = new PostRetrofitModel();
        mLocal = new PostInMemoryModel();
        mView = view;
    }

    public void loadPost(final int postId){
        mRemote.getPostById(postId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Post>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    mView.onError(e.getLocalizedMessage());
                }

                @Override
                public void onNext(Post post) {
                    mView.onPostLoaded(post);
                }
            });
    }


    public void loadComments(int postId){
        mRemote.getCommentsByPostId(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Comment>>() {
                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e.getMessage());
                    }
                    @Override
                    public void onNext(List<Comment> comments) {
                        mView.onCommentsLoaded(comments);
                    }
                });
    }

}
