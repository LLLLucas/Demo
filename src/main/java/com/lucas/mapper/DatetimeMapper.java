package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.Datetime;
import com.lucas.pojo.DatetimeExample;
@Mapper
public interface DatetimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Datetime record);

    int insertSelective(Datetime record);

    List<Datetime> selectByExample(DatetimeExample example);

    Datetime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Datetime record);

    int updateByPrimaryKey(Datetime record);
}