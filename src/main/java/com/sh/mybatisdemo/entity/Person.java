package com.sh.mybatisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created By Sunhu At 2020/5/25 9:36
 *
 * @author Sun
 */
@Document(collection = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
    private Integer age;
    private Integer c;
    private Integer m;
    private Integer e;
    private String country;
    private List books;
    private Address address;
}
