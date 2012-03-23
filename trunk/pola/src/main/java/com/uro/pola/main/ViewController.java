package com.uro.pola.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uro.common.Constants;
import com.uro.pola.codedd.CodeData;


import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;




/**
 * Handles requests for simple routing.
 */
@Controller
@RequestMapping(value="/view")
public class ViewController {

	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{folderName}/{folderName2}", method = RequestMethod.GET)
	public String home( @PathVariable String folderName, @PathVariable String folderName2, Model model  ) throws Exception {
		logger.info("requested jsp : "+ folderName + folderName2 );
		
		model.addAttribute(new CodeData());
		
		return folderName + "/" + folderName2;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{folderName}/{folderName2}/{folderName3}", method = RequestMethod.GET)
	public String home2( @PathVariable String folderName, @PathVariable String folderName2 , @PathVariable String folderName3 ) throws Exception {
		logger.info("requested jsp : "+ folderName +"/"+ folderName2 +"/"+ folderName3);
		

		
		return folderName + "/" + folderName2+ "/" + folderName3;
	}
	
}
