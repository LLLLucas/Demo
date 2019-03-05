package com.lucas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lucas.datetime.DateCreate;
import com.lucas.pojo.Datetime;
import com.lucas.service.DatetimeService;

@Controller
public class DatetimeController {
	@Autowired
	DatetimeService datetimeService;
	@RequestMapping("datetimeCre")
	public ModelAndView datetimeCre() {
		ModelAndView mav=new ModelAndView("redirect:/datetimeList");
		DateCreate dateCreate=new DateCreate();
		List<Datetime> datetimeList=dateCreate.dateCre();
		datetimeService.insert(datetimeList);
		return mav;
		
	}
	@RequestMapping("datetimeList")
	public ModelAndView datetimeList() {
		ModelAndView mav=new ModelAndView("datetimeList");
		List<Datetime> datetimeList=datetimeService.list();
		mav.addObject("datetimeList", datetimeList);
		return mav;
		
	}
}
