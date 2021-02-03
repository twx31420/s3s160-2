package edu.nf.homework.dao;

import edu.nf.homework.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public interface UserDao {
    List<User> select();

    void add(User user);
}
