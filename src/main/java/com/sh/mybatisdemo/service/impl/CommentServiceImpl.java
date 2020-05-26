package com.sh.mybatisdemo.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.dao.CommentRepository;
import com.sh.mybatisdemo.entity.Comment;
import com.sh.mybatisdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 15:41
 *
 * @author Sun
 */
@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);


    }

    @Override
    public void updateCommnet(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> queryCommentList() {
        return commentRepository.findAll();
    }

    @Override
    public Comment queryCommentById(String id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Page<Comment> queryCommentListPageByParentid(String parentid, int page, int size) {
        return commentRepository.findByParentid("3", PageRequest.of(page-1,size));
    }

    @Override
    public UpdateResult updateCommentLikenum(String articleId) {
        Query query=new Query(Criteria.where("articleid").is(articleId));
        Update update=new Update();
        update.inc("likenum",2);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, "comment");
        return updateResult;
    }
}
