package com.sh.mybatisdemo.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.sh.mybatisdemo.entity.Person;
import com.sh.mybatisdemo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 9:42
 *
 * @author Sun
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PersonServiceImplTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    PersonService personService;

    @Test
    void queryAll() {
        List<Person> personList = mongoTemplate.findAll(Person.class);
        personList.forEach(System.out::println);


    }

    @Test
    void queryByName() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("sunhu"));
        List<Person> personList = mongoTemplate.find(query, Person.class);
        personList.forEach(System.out::println);

    }

    @Test
    void queryByAge() {

        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(25));
        query.with(Sort.by(Sort.Direction.DESC,"age"));
        List<Person> personList = mongoTemplate.find(query, Person.class);
        personList.forEach(System.out::println);

    }

    //@Test
    //void saveOne(){
    //
    //    Person person=
    //            new Person(null,"sunhu",22,
    //                    55,55,55,"CN", Arrays.asList("java","python"));
    //    Person person1 = mongoTemplate.insert(person);
    //    System.out.println(person1);
    //
    //}


    @Test
    void updateOne() {
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is("sunhu"));

        Update update=new Update();
        //update.set("address",new Address("南京","江宁"));
        //update.set("email","1152662@qq.com");
        //值不存在就插入，存在不执行操作
        update.addToSet("books","c++");
        //upsert 存在更新，不存在就插入
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Person.class);
        System.out.println(updateResult);


    }

    @Test
    void testAggregation(){
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.match(Criteria.where("age").gt(20)),
                Aggregation.group("country").count().as("sum")

        );
        AggregationResults<Person> personAggregationResults = mongoTemplate.aggregate(aggregation, "persons",Person.class);
        personAggregationResults.forEach(System.out::println);

        List<Person> results = personAggregationResults.getMappedResults();
        //results.forEach(System.out::println);

    }
}