package com.clean.sharednode.solution2.model.remote;

import com.clean.sharednode.solution2.model.IPostsModel;
import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;
import com.clean.sharednode.solution2.presenters.rest.ApiProvider;
import com.clean.sharednode.solution2.presenters.rest.PostApi;

import java.util.List;

import rx.Observable;


public class PostRetrofitModel implements IPostsModel {

    private PostApi mApi;

    public PostRetrofitModel() {
        mApi = ApiProvider.getApi().create(PostApi.class);
    }

    @Override
    public Observable<Post> getPostById(int id) {
        return mApi.getPostById(id);
    }

    @Override
    public Observable<List<Comment>> getCommentsByPostId(int id) {
        return mApi.getPostComments(id);
    }
}
