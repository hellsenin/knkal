package com.uro.sprmvc.home;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.uro.common.base.BaseService;

@Repository
public class UserListService /* extends BaseService */ {

	private static final Logger logger = LoggerFactory.getLogger(UserListService.class);
	
	private SqlMapClientTemplate sqlMapClientTemplate;
	@Inject
	public UserListService(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	
	
	

	
	
	
	public List getUserList() throws SQLException{
		logger.info("########################## UserListService   getUserList() ");
		
		//List qlist = sqlMap.queryForList("sample.query1");
		
		List qlist = sqlMapClientTemplate.queryForList("sample.query1");
		
		return qlist;
	}
	
}
