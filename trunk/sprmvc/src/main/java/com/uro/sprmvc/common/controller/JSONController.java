package com.uro.sprmvc.common.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uro.sprmvc.common.model.Shop;
import com.uro.sprmvc.home.HomeController;
 
@Controller
@RequestMapping("/kfc/brands")
public class JSONController {
 
	
	private static final Logger logger = LoggerFactory.getLogger(JSONController.class);
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	
	//  /kfc/brands 다음에 인자가 없으면
	
	@RequestMapping(method = RequestMethod.GET)
	public String doc(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		
		
		List qlist = sqlMapClientTemplate.queryForList("sample.query1");
		
		
		model.addAttribute("qList", qlist);

		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		logger.info(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	//   http://localhost:8080/Sprmvc/kfc/brands/kfc-kampar
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	@ResponseBody 
	public Shop getShopInJSON(@PathVariable String name) {
 
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
 
		return shop;
 
	}
	

	
 
}