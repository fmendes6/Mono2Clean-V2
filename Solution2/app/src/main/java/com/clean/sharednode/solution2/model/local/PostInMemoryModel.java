package com.clean.sharednode.solution2.model.local;

import com.clean.sharednode.solution2.model.IPostsModel;
import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


public class PostInMemoryModel implements IPostsModel {
    List<Post> mPosts;
    List<Comment> mComments;

    public PostInMemoryModel() {
        this.mPosts = new ArrayList<>();
        this.mComments = new ArrayList<>();
    }

    @Override
    public Observable<Post> getPostById(int id) {

        for(Post post : mPosts){

            if(post.getId() == id){
                return Observable.just(post);
            }

        }
        return Observable.empty();
    }

    @Override
    public Observable<List<Comment>> getCommentsByPostId(int id) {
        List<Comment> commentsList = new ArrayList<>();

        for(Comment comment : mComments){

            if(comment.getPostId() == id){
                commentsList.add(comment);
            }

        }
        return Observable.just(commentsList);
    }
}
