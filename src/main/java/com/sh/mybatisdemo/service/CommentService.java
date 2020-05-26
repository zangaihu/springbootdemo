package com.sh.mybatisdemo.service;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.entity.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 15:33
 *
 * @author Sun
 */
public interface CommentService {

    void saveComment(Comment comment);

    void updateCommnet(Comment comment);

    void deleteCommentById(String id);

    List<Comment> queryCommentList();

    Comment queryCommentById(String id);

    Page<Comment> queryCommentListPageByParentid(String parentid, int page , int size);

    UpdateResult updateCommentLikenum(String articleId);

}
