package com.sh.mybatisdemo.service.impl;

import com.sh.mybatisdemo.dao.UserRepository;
import com.sh.mybatisdemo.entity.Address;
import com.sh.mybatisdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created By Sunhu At 2020/5/26 16:05
 *
 * @author Sun
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {

        User user = new User("ddadsa", "233q23q");
        user.setAddress(new Address("南京", "中国"));
        //保存完成后，会将id值给到user
        User save = userRepository.save(user);
        Optional<User> byId = userRepository.findById(save.getId());


        System.out.println(user);
        userRepository.delete(user);


    }

}
