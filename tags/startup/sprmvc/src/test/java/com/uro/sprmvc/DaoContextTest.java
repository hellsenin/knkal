package com.uro.sprmvc;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.uro.sprmvc.home.UserListService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("dao-context.xml")
@TransactionConfiguration(transactionManager="txManager")
@Transactional
public class DaoContextTest {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	private UserListService userListService;
	
	
	
	@Test
	public void testApplicationContext() throws Exception {
		
	}

	

	@Test
	public void testQuery1() throws Exception {
		
		// System.err.println(sqlMapClientTemplate);
		// List list = sqlMapClientTemplate.queryForList("sample.query1");
		// if(list != null){
		// int nList = list.size();
		// for(int i=0; i<nList; i++){
		// HashMap hm = (HashMap)list.get(i);
		// System.out.println(">>"+hm.get("name"));
		// }
		// }
		
		
		userListService = new UserListService(sqlMapClientTemplate);
		
		@SuppressWarnings("rawtypes")
		List list = userListService.getUserList();
		int nList = list.size();
		for (int i = 0; i < nList; i++) {
			@SuppressWarnings("rawtypes")
			HashMap hm = (HashMap) list.get(i);
			System.out.println(">>" + hm.get("name"));
		}
		
		
	}
}
