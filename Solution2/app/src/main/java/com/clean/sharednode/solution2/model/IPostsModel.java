package com.clean.sharednode.solution2.model;

import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;

import java.util.List;

import rx.Observable;


public interface IPostsModel {
    Observable<Post> getPostById(int id);
    Observable<List<Comment>> getCommentsByPostId(int id);
}
