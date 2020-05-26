package com.sh.mybatisdemo.service.impl;

import com.sh.mybatisdemo.entity.Person;
import com.sh.mybatisdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 9:39
 *
 * @author Sun
 */
@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Person> queryAll() {
        return mongoTemplate.findAll(Person.class) ;
    }
}
