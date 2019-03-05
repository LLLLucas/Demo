package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.Yuyue;
import com.lucas.pojo.YuyueExample;
@Mapper
public interface YuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuyue record);

    int insertSelective(Yuyue record);

    List<Yuyue> selectByExample(YuyueExample example);

    Yuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuyue record);

    int updateByPrimaryKey(Yuyue record);
}