package com.sh.mybatisdemo.service.impl;

import com.sh.mybatisdemo.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created By Sunhu At 2020/5/22 11:29
 *
 * @author Sun
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MongoServiceImplTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void findLikes() {

        Query query=new Query();
        query.addCriteria(Criteria.where("updateTime").gt(new Date()));
        List<Book> books = mongoTemplate.find(query, Book.class);
        books.forEach(System.out::println);
        System.out.println(new Date());

    }

}