package com.sh.mybatisdemo.service.impl;

import com.sh.mybatisdemo.entity.Address;
import com.sh.mybatisdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created By Sunhu At 2020/5/26 15:00
 *
 * @author Sun
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void testValue()throws Exception{

        User user = new User("boke","byrant");
        user.setAddress(new Address("南京","中国"));
        //ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("player:1",user,20, TimeUnit.SECONDS); //10秒之后数据消失

        Object o = valueOperations.get("player:1");
        System.out.println(o);

    }


    @Test
    public void testSetOp(){

        SetOperations setOperations = redisTemplate.opsForSet();
        User user1=new User("boke","byrant");
        User user2=new User("aa","bb");

        setOperations.add("userset",user1,user2);

        Set set = setOperations.members("userset");

        System.out.println(set);


    }



}
