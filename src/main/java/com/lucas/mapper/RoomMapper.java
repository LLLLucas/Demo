package com.lucas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lucas.pojo.Room;
import com.lucas.pojo.RoomExample;
@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}