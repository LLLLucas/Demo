package com.lucas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.mapper.DatetimeMapper;
import com.lucas.mapper.TimeMapper;
import com.lucas.mapper.YuyueMapper;
import com.lucas.pojo.Datetime;
import com.lucas.pojo.Room;
import com.lucas.pojo.Time;
import com.lucas.pojo.User;
import com.lucas.pojo.Yuyue;
import com.lucas.pojo.YuyueExample;
import com.lucas.service.DatetimeService;
import com.lucas.service.RoomService;
import com.lucas.service.TimeService;
import com.lucas.service.UserService;
import com.lucas.service.YuyueService;
@Service
public class YuyueServiceImpl implements YuyueService{
	@Autowired
	YuyueMapper yuyueMapper;
	@Autowired
	DatetimeService datetimeService;
	@Autowired
	TimeService timeService;
	@Autowired
	UserService userService;
	@Autowired
	RoomService roomService;
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		yuyueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Yuyue yuyue) {
		// TODO Auto-generated method stub
		yuyueMapper.insert(yuyue);
	}

	@Override
	public List<Yuyue> list() {
		// TODO Auto-generated method stub
		YuyueExample yuyueExample=new YuyueExample();
		yuyueExample.setOrderByClause("id desc");
		List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyueExample);
		for (Yuyue yuyue : yuyueList) {
			System.out.println(yuyue.getReason());
		}
		setUser(yuyueList);
		setRoomname(yuyueList);
		return yuyueList;
		
	}

	@Override
	public Yuyue get(int id) {
		
		return yuyueMapper.selectByPrimaryKey(id);
	}

	@Override
	public Yuyue get(int timeid, int dateid, int roomid) {
		// TODO Auto-generated method stub
		YuyueExample yuyueExample=new YuyueExample();
		yuyueExample.createCriteria().andDateidEqualTo(dateid)
		.andTimeidEqualTo(timeid)
		.andRoomidEqualTo(roomid);
		List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyueExample);
		setUser(yuyueList);
		setRoomname(yuyueList);
		if(yuyueList.isEmpty()) {
			
			return null;
		}else {
			return yuyueList.get(0);
					
		}
	}

	@Override
	public void update(Yuyue yuyue) {
		// TODO Auto-generated method stub
		yuyueMapper.updateByPrimaryKeySelective(yuyue);
	}

	@Override
	public List<Yuyue> list(int roomid) {
		// TODO Auto-generated method stub
		YuyueExample yuyueExample=new YuyueExample();
		yuyueExample.setOrderByClause("id desc");
		yuyueExample.createCriteria().andRoomidEqualTo(roomid);
		List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyueExample);
		setUser(yuyueList);
		setRoomname(yuyueList);
		
		return yuyueList;
	}

	@Override
	public List<Yuyue> listByUserid(int userid) {
		// TODO Auto-generated method stub
		YuyueExample yuyueExample=new YuyueExample();
		yuyueExample.setOrderByClause("id desc");
		yuyueExample.createCriteria().andUseridEqualTo(userid);
		List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyueExample);
		setUser(yuyueList);
		setRoomname(yuyueList);
		return yuyueList;
	}
	
	public void setUser(Yuyue yuyue) {
		if(yuyue!=null) {
			int timeid=yuyue.getTimeid();
			
			int dateid=yuyue.getDateid();
			Datetime dt=datetimeService.get(dateid);
			Time t=timeService.get(timeid);
			String string=dt.getDatetime()+"——"+t.getTime();
			int userid=yuyue.getUserid();
			if(string!=null) {
				yuyue.setTime(string);
			}
			User user=userService.get(userid);
			if(user!=null) {
				yuyue.setUsername(user.getUsername());
			}
		}
	}
	public void setUser(List<Yuyue> yuyueList) {
		for (Yuyue yuyue2 : yuyueList) {
			setUser(yuyue2);
			
		}
	}
	public void setRoomname(Yuyue yuyue) {
		if(yuyue!=null) {
			int roomid=yuyue.getRoomid();
			Room room=roomService.selectById(roomid);
			if(room!=null) {
			yuyue.setRoomname(room.getRoomname());
			}
		}
	}
	
	public void setRoomname(List<Yuyue> yuyueList) {
		for (Yuyue yuyue : yuyueList) {
			setRoomname(yuyue);
			
		}
	}

	@Override
	public List<Yuyue> listByZhuangtai(String st) {
		
		if(st.equals("wait")) {
		// TODO Auto-generated method stub
		YuyueExample yuyeExample=new YuyueExample();
		yuyeExample.createCriteria().andZhuangtaiEqualTo("wait");
		List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyeExample);
		setUser(yuyueList);
		setRoomname(yuyueList);
		return yuyueList;
		}else if(st.equals("post")){
			YuyueExample yuyeExample=new YuyueExample();
			yuyeExample.createCriteria().andZhuangtaiEqualTo("post");
			List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyeExample);
			setUser(yuyueList);
			setRoomname(yuyueList);
			return yuyueList;
			
		}else {
			YuyueExample yuyeExample=new YuyueExample();
			yuyeExample.setOrderByClause("id asc");
			List<Yuyue> yuyueList=yuyueMapper.selectByExample(yuyeExample);
			setUser(yuyueList);
			setRoomname(yuyueList);
			return yuyueList;
			
		}
	}
	
	

}
