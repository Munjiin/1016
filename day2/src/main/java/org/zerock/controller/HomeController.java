package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	@GetMapping("/home2")
	public void home2(String str,Model model) { //jsp로 보내는 건 model
		logger.info("str..");
		logger.info(str);
		model.addAttribute("str",str);
	}//jsp 만들기
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		String formattedDate = mapper.getTime2();
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
