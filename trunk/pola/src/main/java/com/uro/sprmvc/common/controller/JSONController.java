package com.uro.sprmvc.common.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uro.sprmvc.common.model.Shop;

 
@Controller
@RequestMapping("/kfc/brands")
public class JSONController {
 
	
	private static final Logger logger = LoggerFactory.getLogger(JSONController.class);
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	
	//  /kfc/brands
	
	@RequestMapping(method = RequestMethod.GET)
	public String doc(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		
		
		List qlist = sqlMapClientTemplate.queryForList("samplemap.query1");
		
		
		model.addAttribute("qList", qlist);

		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		logger.info(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	//   http://localhost:8080/pola/kfc/brands/kfc-kampar
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	@ResponseBody 
	public Shop getShopInJSON(@PathVariable String name) {
 
		System.out.println(name);
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"코리안", "mkyong2"});
 
		return shop;
 
	}
	
	@RequestMapping(value="/popup/getMessageByTncodeKeyMsg.web", method=RequestMethod.POST)
	public @ResponseBody String getMessageByTncodeKeyMsg (
			@RequestParam("tncode") String tunnelCode, 
			@RequestParam("key") String key, 
			@RequestParam("msg") String msg) throws UnsupportedEncodingException {
		
		logger.debug("++++++++++++ tncode = " + tunnelCode + " ++++++++++++");
		logger.debug("++++++++++++ key = " + key + " ++++++++++++");
		logger.debug("++++++++++++ msg = " + msg + " ++++++++++++");
		System.out.println(URLDecoder.decode(msg, "UTF-8"));
		HashMap<String, String> paramForGetMessage = new HashMap<String, String>();
		paramForGetMessage.put("tunnelCode", tunnelCode);
		paramForGetMessage.put("key", key);
// 디코더 해준다.
		//paramForGetMessage.put("msg", URLDecoder.decode(msg, "UTF-8").split("-")[1]);
		
		String message = "한글로 메시지 보내기";
// 인코딩해서 보낸다.		
		//return URLEncoder.encode(message, "UTF-8")
		return message;
	}

	
 
}