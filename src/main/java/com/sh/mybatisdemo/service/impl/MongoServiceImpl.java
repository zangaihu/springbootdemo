package com.sh.mybatisdemo.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.entity.Book;
import com.sh.mybatisdemo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created By Sunhu At 2020/5/21 19:25
 *
 * @author Sun
 */
@Service("mongoService")
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public String saveBook(Book book) {
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
         mongoTemplate.save(book);
        return  "成功";
    }

    @Override
    public List<Book> findAll() {


        return mongoTemplate.findAll(Book.class);
    }

    @Override
    public UpdateResult updateOne(Book book) {
        Query query=new Query(Criteria.where("_id").is(book.getId()));
        Update update=new Update().set("name",book.getName()).set("info",new Date());
       // 更新符合的第一条结果
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Book.class);
        ////更新全部符合的结果
        //mongoTemplate.updateMulti();
        ////不存在则添加
        //mongoTemplate.upsert();

        return updateResult;
    }

    @Override
    public List<Book> findLikes(String search) {
        Query query=new Query();
        query.addCriteria(Criteria.where("updateTime").lt(new Date()));
        return null;
    }

    @Override
    public Book findById(String id) {
        Query query=new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,Book.class);
    }


    @Override
    public String updatePrice(String id,String price) {
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        update.set("price","456123");
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Book.class);

        return null;
    }
}
