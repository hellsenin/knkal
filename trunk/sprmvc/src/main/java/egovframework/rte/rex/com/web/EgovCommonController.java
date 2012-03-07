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
package egovframework.rte.rex.com.web;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 공통 기능을 관리하는 컨트롤러 클래스를 정의한다.
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
public class EgovCommonController {
	
	@Resource(name="messageSource")
	private MessageSource messageSource;

    /**
     * 권한이 없는 사용자가 접근시 권한제한 화면으로 이동한다.
     * @return "cmmn/EgovAccessDenie"
     * @exception Exception
     */
    @RequestMapping("/com/accessDenied.do")
    public String accessDenied() throws Exception {
        return "cmmn/EgovAccessDenied";
    }
    
    /** 메인페이지로 이동한다.
     * @return "main/EgovMain"
     * @exception Exception
     */
	@RequestMapping(value="/com/egovMain.do", method=RequestMethod.GET)
	protected String changeLocale() throws Exception {
		String op = messageSource.getMessage("button.search", null, Locale.getDefault());
		System.out.println(op);
		return "main/EgovMain";
	}
	
	
	
}
