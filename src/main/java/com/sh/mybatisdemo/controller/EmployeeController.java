package com.sh.mybatisdemo.controller;

import com.sh.mybatisdemo.dto.EmployeeDto;
import com.sh.mybatisdemo.entity.Employee;
import com.sh.mybatisdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2020-05-20 08:52:32
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Employee selectOne( Integer id) {
        return employeeService.queryById(id);
    }


    @GetMapping("/query")
    public EmployeeDto queryWithDeptById(Integer id)
    {

        EmployeeDto employee = employeeService.queryWithDeptById(id);
        System.out.println(employee);
        return employee;
    }
}