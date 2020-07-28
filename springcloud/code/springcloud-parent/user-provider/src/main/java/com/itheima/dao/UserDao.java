package com.itheima.dao;

import com.itheima.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 周盼龙
 * @date 2020/3/25 16:14
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
