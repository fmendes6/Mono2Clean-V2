package com.clean.sharednode.solution2.presenters.rest;

import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;


public interface PostApi {

    @GET("/posts/{postId}")
    Observable<Post> getPostById(@Path("postId") int postId);

    @GET("/posts/{postId}/comments")
    Observable<List<Comment>> getPostComments(@Path("postId") int postId);
}
