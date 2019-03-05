package com.lucas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lucas.pojo.Datetime;
import com.lucas.pojo.Room;
import com.lucas.pojo.Time;
import com.lucas.pojo.Type;
import com.lucas.pojo.User;
import com.lucas.pojo.Yuyue;
import com.lucas.service.DatetimeService;
import com.lucas.service.DatetimeWeek;
import com.lucas.service.RoomService;
import com.lucas.service.TimeService;
import com.lucas.service.TypeService;
import com.lucas.service.UserService;
import com.lucas.service.YuyueService;

@Controller
public class TimeController {
	@Autowired
	TypeService typeService;
	@Autowired
	UserService userService;
	@Autowired
	RoomService roomService;
	@Autowired
	YuyueService yuyueService;
	@Autowired
	DatetimeService datetimeService;
	@Autowired
	TimeService timeService;
	/**
	 * 显示本周的预约表
	 * @param roomid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yuyue")
	public ModelAndView yuyue(Integer roomid,HttpSession session) throws Exception{
		Date date = new Date();
	        //设置要获取到什么样的时间
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        //获取String类型的时间
	    String createdate = sdf.format(date);
		int weekid=DatetimeWeek.getWeek(createdate);
		ModelAndView mav=null;
		if(session.getAttribute("user")!=null) {
			mav=new ModelAndView("yuyue");
		List<Time> timeList=timeService.list();
		
		List<Datetime> datetimeList=datetimeService.list();
		List<Datetime> datetimeList2=new ArrayList<Datetime>();
		
		for (Datetime datetime : datetimeList) {
			
			if(datetime.getWeekid()==weekid) {
				datetimeList2.add(datetime);
			}
		}
	
		
		Room  room=roomService.get(roomid);
		Type type=typeService.get(room.getTypeid());
		System.out.println(timeList.get(0).getTime());
		System.out.println(datetimeList.get(0).getDatetime());
 		mav.addObject("timeList", timeList);
		mav.addObject("datetimeList", datetimeList2);
		mav.addObject("room", room);
		mav.addObject("type", type);
		mav.addObject("roomid", roomid);
		mav.addObject("weekid", weekid);
		mav.addObject("service", yuyueService);
		return mav;
		}else {
			System.out.println("没有登录 返回主页面");
			mav=new ModelAndView("login");
			return mav;
		}
	}
	/**
	 * 显示上周的预约表
	 * 
	 * @param roomid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yuyueLast")
	public ModelAndView yuyueLast(Integer roomid,HttpSession session,int weekid) throws Exception{
		int weekid2=weekid;
		ModelAndView mav=null;
		if(session.getAttribute("user")!=null) {
			mav=new ModelAndView("yuyue");
		List<Time> timeList=timeService.list();
		
		List<Datetime> datetimeList=datetimeService.list();
		List<Datetime> datetimeList2=new ArrayList<Datetime>();
		
		for (Datetime datetime : datetimeList) {
			if(weekid2==1) {
				if(datetime.getWeekid()==52) {
					datetimeList2.add(datetime);
				}
			}else {
				if(datetime.getWeekid()==(weekid-1)) {
					datetimeList2.add(datetime);
				}
			}
			
		}
		weekid2=weekid2-1;
		
		System.out.println("上周的日期查找结果");
		for (Datetime datetime : datetimeList2) {
			System.out.println(datetime.getDatetime());
		}
		Room  room=roomService.get(roomid);
		Type type=typeService.get(room.getTypeid());
		System.out.println(timeList.get(0).getTime());
		System.out.println(datetimeList.get(0).getDatetime());
 		mav.addObject("timeList", timeList);
		mav.addObject("datetimeList", datetimeList2);
		mav.addObject("room", room);
		mav.addObject("type", type);
		mav.addObject("roomid", roomid);
		mav.addObject("weekid", weekid2);
		mav.addObject("service", yuyueService);
		return mav;
		}else {
			System.out.println("没有登录 返回主页面");
			mav=new ModelAndView("login");
			return mav;
		}
	}
	/**
	 * 显示下周的预约表
	 * @param roomid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yuyueNext")
	public ModelAndView yuyueNext(Integer roomid,HttpSession session,int weekid) throws Exception{
		/*Date date = new Date();
	        //设置要获取到什么样的时间
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        //获取String类型的时间
	    String createdate = sdf.format(date);
		int weekid=DatetimeWeek.getWeek(createdate);*/
		int weekid2=weekid;
		
		ModelAndView mav=null;
		if(session.getAttribute("user")!=null) {
			mav=new ModelAndView("yuyue");
		List<Time> timeList=timeService.list();
		
		List<Datetime> datetimeList=datetimeService.list();
		List<Datetime> datetimeList2=new ArrayList<Datetime>();
		for (Datetime datetime : datetimeList) {
			System.out.println(datetime.getWeekid()+"----"+datetime.getDatetime());
			
			
		}
		
		for (Datetime datetime : datetimeList) {
			if(weekid2==52) {
				if(datetime.getWeekid()==1) {
					datetimeList2.add(datetime);
					weekid2=1;
				}
			}else {
				if(datetime.getWeekid()==(weekid2+1)) {
					datetimeList2.add(datetime);
					
				}
			}
		}
		weekid2=weekid2+1;
	
		
		System.out.println("下周的日期查找结果");
		for (Datetime datetime : datetimeList2) {
			System.out.println(datetime.getWeekid()+"---"+datetime.getDatetime());
		}
		Room  room=roomService.get(roomid);
		Type type=typeService.get(room.getTypeid());
		System.out.println(timeList.get(0).getTime());
		System.out.println(datetimeList.get(0).getDatetime());
 		mav.addObject("timeList", timeList);
		mav.addObject("datetimeList", datetimeList2);
		mav.addObject("room", room);
		mav.addObject("type", type);
		mav.addObject("roomid", roomid);
		mav.addObject("weekid", weekid2);
		mav.addObject("service", yuyueService);
		return mav;
		}else {
			System.out.println("没有登录 返回主页面");
			mav=new ModelAndView("login");
			return mav;
		}
	}
	/**&
	 * 预约操作
	 * @param yuyue
	 * @return
	 */
	@RequestMapping("yuyue1")
	public ModelAndView yuyue(Yuyue yuyue) {
		ModelAndView mav=new ModelAndView("redirect:/yuyue?roomid="+yuyue.getRoomid());
		Yuyue yuyueCheck=yuyueService.get(yuyue.getTimeid(), yuyue.getDateid(), yuyue.getRoomid());
		if(yuyueCheck==null) {
			yuyueService.insert(yuyue);
			mav.addObject("success","预约成功");
			System.out.println("预约成功");
			yuyueService.list();
			return mav;
		}else {
			mav.addObject("error", "改日期时间已经预约");
			System.out.println("已经预约，该日期改时间不能预约");
			return mav;
		}
	}
	@RequestMapping("AdminAudit")
	public ModelAndView AdminAudit(Yuyue yuyue,HttpSession session) {
		if(session.getAttribute("user")!=null) {
		ModelAndView mav=new ModelAndView("AdminAudit");
		List<Yuyue> yuyueList=yuyueService.listByZhuangtai("");
		if(yuyueList==null) {
			System.out.println("没有查找到");
		}else{
			for (Yuyue yuyue2 : yuyueList) {
				System.out.println(yuyue2.getZhuangtai());
			}
			mav.addObject("yuyueList", yuyueList);	
			
		}
		return mav;
		}else {
			ModelAndView mav=new ModelAndView("adminlogin");
			System.out.println("管理员没有登录，返回登录页面");
			return mav;
			
		}
	}
	@RequestMapping("AdminPosted")
	public ModelAndView AdminPosted() {
		ModelAndView mav=new ModelAndView("AdminAudit");
		List<Yuyue> yuyueList=yuyueService.listByZhuangtai("post");
		if(yuyueList==null) {
			System.out.println("没有查找到");
		}else{
			for (Yuyue yuyue2 : yuyueList) {
				System.out.println(yuyue2.getZhuangtai());
			}
			mav.addObject("yuyueList", yuyueList);	
			
		}
		return mav;
	}
	@RequestMapping("AdminRefuse")
	public ModelAndView AdminRefuse(int id) {
		ModelAndView mav=new ModelAndView("redirect:/AdminAudit");
		Yuyue yuyue=yuyueService.get(id);
		yuyue.setZhuangtai("refuse");
	
		yuyueService.update(yuyue);
		return mav;
	}
	@RequestMapping("AdminPost")
	public ModelAndView AdminPost(int id) {
		ModelAndView mav=new ModelAndView("redirect:/AdminAudit");
		Yuyue yuyue=yuyueService.get(id);
		yuyue.setZhuangtai("post");
	
		yuyueService.update(yuyue);
		return mav;
	}
	@RequestMapping("AllYuyue")
	public ModelAndView AllYuyue() {
		ModelAndView mav=new ModelAndView("AdminAudit");
		List<Yuyue> yuyueList=yuyueService.list();
	
		
		if(!yuyueList.isEmpty()) {
			
			System.out.println("所有预约查找到了");
		}else {
			System.out.println("所有预约没有找到");
		}
		
		
		mav.addObject("yuyueList", yuyueList);
	
		return mav;
	}
	/**
	 * 去审核 待审核的预约
	 * @return
	 */
	@RequestMapping("ToPost")
	public ModelAndView ToPost() {
		ModelAndView mav=new ModelAndView("AdminAudit");
		List<Yuyue> yuyueList=yuyueService.listByZhuangtai("wait");
	
		
		if(!yuyueList.isEmpty()) {
			
			System.out.println("所有预约查找到了");
		}else {
			System.out.println("所有预约没有找到");
		}
		
		
		mav.addObject("yuyueList", yuyueList);
	
		return mav;
	}
	
	@RequestMapping("myyuyue")
	public ModelAndView myyuyue(int userid) {
		ModelAndView mav=new ModelAndView("myyuyue");
		List<Yuyue> myyuyueList=yuyueService.listByUserid(userid); 
		User user=userService.get(userid);
		
	
		
		if(!myyuyueList.isEmpty()) {
			
			System.out.println("我的预约查找到了");
		}else {
			System.out.println("我的预约没有找到");
		}
		for (Yuyue yuyue : myyuyueList) {
			System.out.println(yuyue.getUsername());
			System.out.println(yuyue.getRoomname());
			System.out.println(yuyue.getTime());
			
		}
		
		mav.addObject("userid", userid);
		mav.addObject("user", user);
		mav.addObject("myyuyueList", myyuyueList);
	
		return mav;
	}
	@RequestMapping("delete")
	public ModelAndView delete(int id,int userid) {
		ModelAndView mav=new ModelAndView("redirect:/myyuyue?userid="+userid);
		yuyueService.delete(id);
		return mav;
	}

}
