package com.uro.sprmvc.home;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	@Autowired
//	private SqlMapClientTemplate sqlMapClientTemplate;
	
	private UserListService userListService;

	@Inject
	public HomeController(UserListService userListService) {
		this.userListService = userListService;
		
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Transactional
	public String home(Locale locale, Model model) throws SQLException {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		//UserListService service = new UserListService();
		
		List qlist = userListService.getUserList();
		
		//List qlist = sqlMapClientTemplate.queryForList("sample.query1");
		
		
		model.addAttribute("qList", qlist);

		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		logger.info(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
