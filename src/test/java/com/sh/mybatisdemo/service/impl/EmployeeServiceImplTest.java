package com.sh.mybatisdemo.service.impl;

import com.sh.mybatisdemo.dao.EmployeeDao;
import com.sh.mybatisdemo.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created By Sunhu At 2020/5/20 10:37
 *
 * @author Sun
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Resource
    private EmployeeDao employeeDao;

    @Test
    void queryById() {
    }

    @Test
    void queryAllByLimit() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    //@Transactional(rollbackFor = Throwable.class)
    void queryWithDeptById() {

        EmployeeDto employee = employeeDao.queryWithDeptById(1);
        EmployeeDto emp2=employeeDao.queryWithDeptById(1);
        System.out.println(employee==emp2);


    }
}