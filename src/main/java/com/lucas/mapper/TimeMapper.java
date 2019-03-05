package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.Time;
import com.lucas.pojo.TimeExample;
@Mapper
public interface TimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Time record);

    int insertSelective(Time record);

    List<Time> selectByExample(TimeExample example);

    Time selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
}