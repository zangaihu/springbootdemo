package com.sh.mybatisdemo.dao;

import com.sh.mybatisdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By Sunhu At 2020/5/26 16:02
 *
 * @author Sun
 */
public interface UserRepository extends CrudRepository<User,String> {



}
