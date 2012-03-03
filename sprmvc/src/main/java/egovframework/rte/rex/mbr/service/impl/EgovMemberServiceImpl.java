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
package egovframework.rte.rex.mbr.service.impl;


import javax.annotation.Resource;

import org.springframework.security.providers.encoding.Md5PasswordEncoder;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.rex.mbr.service.EgovMemberService;
import egovframework.rte.rex.mbr.service.MemberVO;

/**
 * 회원관리에 관한 비지니스클래스를 정의한다.
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
@Service("memberService")
@Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
public class EgovMemberServiceImpl implements EgovMemberService{

	/** MemberDAO */
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;  //회원정보 관련 데이터베이스 접근 클래스
	
	/**
	 * 입력된 정보로 데이터베이스에 접근하여 회원 여부를 확인하고, 회원일 경우 로그인 후 메인화면으로 이동한다.
	 * @param MemberVO 회원번호
	 * @return MemberVO 회원번호
	 * @throws Exception 
	 */
	public MemberVO loginMember(MemberVO memberVO) throws Exception {
		
		// 1. 입력한 비밀번호를 암호화한다.
		PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword(memberVO.getPassword(), null);
	    memberVO.setPassword(hashedPass);


        
        MemberVO loginVO = memberDAO.checkMember(memberVO);
        
        if (loginVO != null && !loginVO.getId().equals("")
                && !loginVO.getPassword().equals("")) {
                return loginVO;
            } else {
                loginVO = new MemberVO();
          }
		return loginVO;
	}
}
