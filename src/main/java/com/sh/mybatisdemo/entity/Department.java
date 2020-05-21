package com.sh.mybatisdemo.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-05-20 10:30:25
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -40569748301580309L;
    
    private Integer id;
    
    private String departmentname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

}