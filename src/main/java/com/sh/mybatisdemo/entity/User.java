package com.sh.mybatisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created By Sunhu At 2020/5/26 14:54
 *
 * @author Sun
 */
@RedisHash("people")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 8887888459937445844L;

    String id;
    String firstName;
    String lastName;
    Address address;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
