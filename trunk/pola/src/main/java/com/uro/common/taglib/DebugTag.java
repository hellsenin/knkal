package com.uro.common.taglib;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;

/** Logs a debug message to the current commons.logging category.
  *
  * @author <a href="mailto:joeo@epesh.com">Joseph Ottinger</a>
  * @author <a href="mailto:jstrachan@apache.org">James Strachan</a>
  */

public class DebugTag extends LoggerTag {
    

	

	protected boolean isEnabled(Log logCategory) {
        return logCategory.isDebugEnabled();
    }

    protected void log(Log logCategory, String message) {
    	message += "  [" + ((HttpServletRequest) pageContext
				.getRequest()).getRequestURI() + "]";
    	((HttpServletRequest) pageContext.getRequest()).setAttribute("jspName", ((HttpServletRequest) pageContext
				.getRequest()).getRequestURI());
        logCategory.debug(message);
    }
}

