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
package egovframework.rte.rex.cgr.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.rex.cgr.service.CategoryVO;

/**
 * 카테고리 정보에 관한 데이터 접근 클래스를 정의한다.
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
@Repository("categoryDAO")
@Transactional
public class CategoryDAO extends HibernateDaoSupport {
	
	/**
	 * hibernate를 사용하기 위해 sessionFactory객체를 설정한다.
	 * @param sessionFactory
	 */
	@Autowired
	public void setHibernateDaoSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/** 
	 * 카테고리의 전체 목록을 데이터베이스에서 읽어와 화면에 출력한다.
	 * @return List<CategoryVO> 카테고리정보 리스트
	 * @throws Exception
	 */
	public List<CategoryVO> selectCategoryList() throws Exception{
		return super.getHibernateTemplate().loadAll(CategoryVO.class);
	}
	
	/**
	 * 조회할 카테고리 정보의 갯수를 가져온다.
	 * @param vo SearchVO
	 * @return int 카테고리 갯수
	 * @throws Exception
	 */
//	public int selectCategoryListTotCnt() throws Exception{
//		return selectCategoryList().size();
//	}
	
}
