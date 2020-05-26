package com.sh.mybatisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created By Sunhu At 2020/5/25 10:12
 *
 * @author Sun
 */
//@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = -1171080805273061155L;
    private String city;
    private String area;


}
