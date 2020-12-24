package io.github.ihelin.demo.mybatis.mapper;

import io.github.ihelin.demo.mybatis.entity.User;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);
}
