package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.Type;
import com.lucas.pojo.TypeExample;
@Mapper
public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}