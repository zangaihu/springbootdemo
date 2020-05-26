package com.sh.mybatisdemo.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.entity.Comment;
import com.sh.mybatisdemo.service.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 15:43
 *
 * @author Sun
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    @Test
    void testsaveComment() {
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        comment.setParentid("3");

        commentService.saveComment(comment);


    }

    @Test
    void updateCommnet() {
    }

    @Test
    void deleteCommentById() {
    }

    @Test
    void queryCommentList() {

        List<Comment> commentList = commentService.queryCommentList();
        commentList.forEach(System.out::println);
    }

    @Test
    void queryCommentById() {

        Comment comment = commentService.queryCommentById("5ecb7813c6484471491a1cec");
        System.out.println(comment);
    }

    @Test
    void queryCommentListPageByParentid() {
        Page<Comment> comments = commentService.queryCommentListPageByParentid("3", 1, 2);
        System.out.println(comments.getTotalElements());
        System.out.println(comments.getContent());

    }

    @Test
    void updateCommentLikenum() {
        UpdateResult updateResult = commentService.updateCommentLikenum("100000");
        System.out.println(updateResult);
    }



}