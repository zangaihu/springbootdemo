package com.sh.mybatisdemo.dao;

import com.sh.mybatisdemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created By Sunhu At 2020/5/22 8:55
 *
 * @author Sun
 */
public interface BookRepository extends MongoRepository<Book,Integer> {

    public Book findBookByName(String name);


}
