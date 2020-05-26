package com.sh.mybatisdemo.dao;

import com.sh.mybatisdemo.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created By Sunhu At 2020/5/25 15:31
 *
 * @author Sun
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    //根据父id，查询子评论的分页列表
    Page<Comment> findByParentid(String parentid, Pageable pageable);

}
