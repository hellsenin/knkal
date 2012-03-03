package com.uro.common.base;

import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class DateTypeHandler implements TypeHandlerCallback {

	public void setParameter(ParameterSetter setter, Object parameter)
			throws SQLException {
		if (parameter == null) {
			setter.setNull(Types.BIGINT);
		} else {
			Date datetime = (Date) parameter;
			setter.setTimestamp(new java.sql.Timestamp(datetime.getTime()));
			//setter.setLong(datetime.getTime());
		}
	}

	public Object getResult(ResultGetter getter) throws SQLException {
		long millis = getter.getLong();
		if (getter.wasNull()) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
		return sdf.format(new Date(millis));
	}

	public Object valueOf(String s) {
		return s;
	}
}
