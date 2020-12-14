package me.ianhe.mybatis.mapper;

import me.ianhe.mybatis.entity.User;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);
}
