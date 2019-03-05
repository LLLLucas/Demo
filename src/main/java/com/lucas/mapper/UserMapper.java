package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.User;
import com.lucas.pojo.UserExample;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}