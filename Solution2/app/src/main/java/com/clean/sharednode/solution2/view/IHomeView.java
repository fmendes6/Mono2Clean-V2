package com.clean.sharednode.solution2.view;

import com.clean.sharednode.solution2.model.domain.Comment;
import com.clean.sharednode.solution2.model.domain.Post;

import java.util.List;


public interface IHomeView {

    void onPostLoaded(Post post);

    void onCommentsLoaded(List<Comment> comments);

    void onError(String error);
}
