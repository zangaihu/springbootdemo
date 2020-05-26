package com.sh.mybatisdemo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created By Sunhu At 2020/5/25 10:12
 *
 * @author Sun
 */
@Document
@Data
public class Address {

    private String city;
    private String area;

    public Address(String city, String area) {
        this.city = city;
        this.area = area;
    }
}
