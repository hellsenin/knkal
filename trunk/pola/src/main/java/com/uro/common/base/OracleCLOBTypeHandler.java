package com.uro.common.base;

import java.sql.Clob;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * 
 * <resultMap id="xmlRslt" class="essay">
 *   <result property="content" column="content" typeHandler="OracleCLOBTypeHandler"/>
 * </resultMap>
 *
 * <statement id="getXMLData" resultMap="xmlRslt">
 *   select content from essay
 * </statement> 
 *
 */

public class OracleCLOBTypeHandler implements TypeHandlerCallback {

	protected static Log log = LogFactory.getLog(OracleCLOBTypeHandler.class);
	
    public void setParameter(ParameterSetter setter, Object param) throws SQLException {

        try {
            setter.setClob((Clob) param);
        } catch (SQLException e) {
            if (log.isErrorEnabled())
                log.error("Failed to set CLOB parameter");
            throw e;
        }
    }


    public Object getResult(ResultGetter getter) throws SQLException {

        Clob clob = null;
        try {
            clob = getter.getClob();
        } catch (SQLException e) {
            if (log.isErrorEnabled())
                log.error("Failed to set CLOB result property");
            throw e;
        }

        return clob;
    }

    public Object valueOf(String arg0) {

        return arg0;
    }

}