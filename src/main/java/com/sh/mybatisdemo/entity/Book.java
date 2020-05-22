package com.sh.mybatisdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created By Sunhu At 2020/5/21 19:21
 *
 * @author Sun
 */
@Document(collection = "book")
@Data
public class Book {

    @Id
    private String id;
    private Integer price;
    private String name;
    private String info;
    private String publish;
    private Date createTime;
    private Date updateTime;

}
