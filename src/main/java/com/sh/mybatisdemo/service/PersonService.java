package com.sh.mybatisdemo.service;

import com.sh.mybatisdemo.entity.Person;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 9:39
 *
 * @author Sun
 */
public interface PersonService {


    List<Person> queryAll();
}
