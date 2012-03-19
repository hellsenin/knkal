package com.uro.pola.job;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uro.common.Constants;

import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.cop.bbs.service.EgovBBSManageService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;




/**
 * Handles requests for the application home page.
 */
@Controller
public class JobController {

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	

	@Resource(name = "EgovBBSManageService")
    private EgovBBSManageService bbsMngService;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/currentJobList", method = RequestMethod.GET)
	public String jobList(Locale locale, Model model ) throws Exception {
		
		
		
		return "main/home2";
	}
	
}
