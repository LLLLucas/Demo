package com.lucas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.mapper.TypeMapper;
import com.lucas.pojo.Type;
import com.lucas.pojo.TypeExample;
import com.lucas.service.TypeService;
@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	TypeMapper typeMapper;
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		typeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Type type) {
		// TODO Auto-generated method stub
		typeMapper.insert(type);
	}

	@Override
	public void update(Type type) {
		// TODO Auto-generated method stub
		typeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public List<Type> list() {
		// TODO Auto-generated method stub
		TypeExample typeExample=new TypeExample();
		typeExample.setOrderByClause("id desc");
		List<Type> typeList=typeMapper.selectByExample(typeExample);
		return typeList;
	}

	@Override
	public Type get(int id) {
		// TODO Auto-generated method stub
		Type type =typeMapper.selectByPrimaryKey(id);
		return type;
	}
	

}
