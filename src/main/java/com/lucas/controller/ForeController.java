package com.lucas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lucas.pojo.Room;
import com.lucas.pojo.Type;
import com.lucas.pojo.User;
import com.lucas.service.RoomService;
import com.lucas.service.TypeService;
/*import com.lucas.service.TypeService;*/
import com.lucas.service.UserService;


@Controller
public class ForeController {
	@Autowired
	UserService userService;
	
	@Autowired
	TypeService typeService;
	@Autowired
	RoomService roomService;
	@RequestMapping("login_check")
	public ModelAndView login_check(User user,HttpSession session) {
		ModelAndView mav=null;
		String username=user.getUsername();
		String password=user.getPassword();
		if(username.equals("") || password.equals("")) {
			mav=new ModelAndView("login");
			System.out.println("没有输入用户名或者密码");
			return mav;
		}else {
			
		
		boolean flag=userService.login(user);
		User user2=userService.get(user.getUsername(), user.getPassword());
		if(flag) {
			System.out.println("进来了选择type");
			mav=new ModelAndView("redirect:/homePage");
			session.setAttribute("user", user2);
			return mav;
		}else {
			System.out.println("用户名或者密码错误");
			mav=new ModelAndView("login");
			return mav;
		}
		
		}
		
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		if(session.getAttribute("user")!=null) {
			session.removeAttribute("user");
		}
		return new ModelAndView("redirect:/homePage");
	}
	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView modelAndView  = new ModelAndView("login");
		
		return modelAndView;
		
	}
	@RequestMapping("adminlogin")
	public ModelAndView adminlogin() {
		ModelAndView modelAndView  = new ModelAndView("adminlogin");
		
		return modelAndView;
		
	}
	@RequestMapping("adminlogin_check")
	public ModelAndView adminlogin_check(User user,HttpSession session) {
		ModelAndView modelAndView=null;
		if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")) {
			session.setAttribute("user", user);
			 modelAndView  = new ModelAndView("AdminMeun");
			return modelAndView;
		}else {
			modelAndView  = new ModelAndView("adminlogin");
			return modelAndView;
		}
		
		
	}
	
	
	@RequestMapping("register")
	public ModelAndView register() {
		ModelAndView modelAndView  = new ModelAndView("register");
		
		return modelAndView;
		
	}
	@RequestMapping("register_check")
	public ModelAndView register_check(User user) {
		User user2=userService.get(user.getUsername());//判断是否存在改用户名
		if(user2==null) {
			userService.insert(user);
			System.out.println("注册成功");
			ModelAndView modelAndView  = new ModelAndView("login");
			
			return modelAndView;
		}else {

		ModelAndView modelAndView  = new ModelAndView("register");
		System.out.println("用户存在，请输入其他账号");
		modelAndView.addObject("error","账号存在，请输入其他用户名");
		return modelAndView;
		}
		
	}
	@RequestMapping("homePage")
	public ModelAndView homePage() {
		ModelAndView modelAndView  = new ModelAndView("homePage");
		List<Type> typeList = typeService.list();
		if(typeList.size()==0) {
			System.out.println("没有查找到");
		}else {
			System.out.println("查找到了");
		}
		modelAndView.addObject("typeList",typeList);
		
		return modelAndView;
		
	}
	@RequestMapping("foreRoom")
	public ModelAndView Rooms(int typeid,HttpSession session) {
		ModelAndView modelAndView =null;
		
			modelAndView=new ModelAndView("foreRoom");
		List<Room> roomList=roomService.list(typeid);
		modelAndView.addObject("roomList",roomList);
		System.out.println(roomList.get(0).getRoomname());
		return modelAndView;
		
		
	}
	

}
