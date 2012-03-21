package com.uro.pola.codedd;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDataService {

	private static final Logger logger = LoggerFactory
			.getLogger(CodeDataService.class);

	private SqlMapClientTemplate sqlMapClientTemplate;

	@Inject
	public CodeDataService(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public Map<String, Object> getCodeList(Map<String, Object> param)
			throws SQLException {
		logger.info("########################## getCodeList() ");

		// List qlist = sqlMap.queryForList("sample.query1");
		long totalC = 0;
		Map<String, Object> retmap = new HashMap<String, Object>();
		List<Map<String, Object>> qlist = null;
		try {
			qlist = sqlMapClientTemplate.queryForList("samplemap.codelist",param);

			if (qlist != null && qlist.get(0) != null) {
				Map temp = qlist.get(0);
				totalC = (Long) temp.get("totalCount");
			}
			retmap.put("dataList", qlist);
			retmap.put("totalCount", totalC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retmap;
	}

}
