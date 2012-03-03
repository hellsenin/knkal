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

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.rex.mbr.service.MemberVO;

/**
 * 회원관리에 관한 데이터 접근 클래스를 정의한다.
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
@Repository("memberDAO")
public class MemberDAO extends EgovAbstractDAO{
	
	/**
	 * 입력된 정보로 데이터베이스에 접근하여 회원 여부를 확인하고, 
	 * 회원일 경우 회원의 정보를 가져온다.
	 * @param vo 회원정보
	 * @return MemberVO 회원정보
	 */
	public MemberVO checkMember(MemberVO vo){
		return (MemberVO)selectByPk("memberDAO.getMember", vo);
	}
	
}
