package com.uro.common.base;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.SqlMapClient;






public class BaseService   {
	
	protected static Log log = LogFactory.getLog(BaseService.class);

	
	protected SqlMapClient sqlMap = EaSqlConfig.getSqlMapInstance();
	
	
	public static String getStringForCLOB(Clob clob) {
        
        StringBuffer sbf = new StringBuffer();
        Reader br = null;
        char[] buf = new char[1024];
        int readcnt;

        try {
            br = clob.getCharacterStream();

            while ((readcnt=br.read(buf,0,1024))!=-1) {
                sbf.append(buf,0,readcnt);
            }

        } catch (Exception e) {
            if (log.isErrorEnabled())
                 log.error("Failed to create String object from CLOB", e);

        }finally{
            if(br!=null)
                try {
                    br.close();
                } catch (IOException e) {
                    if (log.isErrorEnabled())
                        log.error("Failed to close BufferedReader object", e);

               }
        }
        return sbf.toString();
    }  

	
}
