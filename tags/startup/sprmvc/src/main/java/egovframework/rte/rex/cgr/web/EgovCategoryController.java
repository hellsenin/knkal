/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.rte.rex.cgr.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.rte.rex.cgr.service.CategoryVO;
import egovframework.rte.rex.cgr.service.EgovCategoryService;

/**
 * 카테고리 정보를 관리하는 컨트롤러 클래스를 정의한다.
 * @author 실행환경 개발팀 신혜연
 * @since 2011.07.11
 * @version 1.0
 * @see 
 * <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.07.11  신혜연          최초 생성
 * 
 * </pre>
 */
@Controller
@SessionAttributes(types=CategoryVO.class)
public class EgovCategoryController {

	/**CategoryService */
	@Resource(name="categoryService")
	private EgovCategoryService categoryService; // 카테고리정보에 관한 인터페이스클래스
	 
	/**
	 * 카테고리 목록을 출력한다.
	 * @param request
	 * @param model
	 * @return "cgr/egovCategoryList"
	 * @throws Exception
	 */
	@RequestMapping(value="/springrest/cgr", method=RequestMethod.GET)
	public String selectCategoryList(HttpServletRequest request, Model model)
			throws Exception {
		List categoryList = categoryService.selectCategoryList();
		
		List category1 = new ArrayList();
		
		for( int i=categoryList.size()-1; i >=0; i--){
			category1.add(categoryList.get(i));
		}
		
		
		model.addAttribute("categoryList", category1);
		return "cgr/egovCategoryList";
	}
}
