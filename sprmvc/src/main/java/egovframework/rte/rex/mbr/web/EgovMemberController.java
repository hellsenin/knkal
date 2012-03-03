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
package egovframework.rte.rex.mbr.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.rex.com.service.EgovUserUtil;
import egovframework.rte.rex.mbr.service.MemberVO;
/**
 * 회원 정보를 관리하는 컨트롤러 클래스를 정의한다.
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
@SessionAttributes(types=MemberVO.class)
public class EgovMemberController {


    
 /**
     * 로그인 화면으로 이동한다. 이미 로그인 되어 있을 경우, 메인페이지로 이동한다.
     * @param request
     * @param model
     * @return "mbr/egovLogin"
     * @throws Exception
     */
    @RequestMapping("/mbr/loginView.do")
    public String loginView(HttpServletRequest request, Model model) throws Exception{
    	MemberVO vo = EgovUserUtil.getMemberInfo();
    	if(vo != null){
    		return "main/EgovMain";
    	}else{
    		model.addAttribute("login_error", request.getParameter("login_error"));
    		return "mbr/egovLogin";
    	}
    }
    
    /**
     * 로그인 후 메인 화면으로 이동한다. 
     * @param request
     * @param model
     * @return "main/EgovMain"
     * @throws Exception
     */
    @RequestMapping(value = "/mbr/actionMain.do")
    public String actionMain(HttpServletRequest request, Model model)
            throws Exception {
        // Spring Security
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        MemberVO memberVO=EgovUserUtil.getMemberInfo();
        if (!isAuthenticated) {
            return "mbr/egovLogin";
        }else{
        	model.addAttribute("loginVO", memberVO);
        	return "main/EgovMain";
        }
    }
  
	
}
