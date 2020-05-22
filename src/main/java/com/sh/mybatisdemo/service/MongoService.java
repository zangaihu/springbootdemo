package com.sh.mybatisdemo.service;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.entity.Book;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/21 19:25
 *
 * @author Sun
 */
public interface MongoService {
    String saveBook(Book book);

    List<Book> findAll();

    Book findById(String id);

    List<Book> findLikes(String search);

    UpdateResult updateOne(Book book);

    String updatePrice(String id,String price);
}
