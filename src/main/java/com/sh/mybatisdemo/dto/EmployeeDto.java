package com.sh.mybatisdemo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created By Sunhu At 2020/5/20 11:10
 *
 * @author Sun
 */
@Data
public class EmployeeDto implements Serializable {

    private Integer id;
    private String lastname;
    private String email;
    private Integer gender;
    private Object birth;
    private Integer dId;
    private String  departmentname;
}
