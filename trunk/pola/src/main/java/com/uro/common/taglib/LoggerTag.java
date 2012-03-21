package com.uro.common.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** Abstract base class for the logging tags which log a message to a 
  * commons.logging category.
  *
  * @author <a href="mailto:joeo@epesh.com">Joseph Ottinger</a>
  * @author <a href="mailto:jstrachan@apache.org">James Strachan</a>
  */

public abstract class LoggerTag extends BodyTagSupport {
    
    private String category;
    private String message;

    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    // Tag interface
    //------------------------------------------------------------------------- 
    public int doStartTag() throws JspException  {
        if ( message != null ) {
            Log logCategory = getLoggingCategory();
            if ( isEnabled( logCategory ) ) {
                // Log now as doAfterBody() may not be called for an empty tag 
                log( logCategory, message );
            }
            return SKIP_BODY;
        }
        return EVAL_BODY_TAG;
    }
    
    public int doAfterBody() throws JspException {
        if (message == null) {
            Log logCategory = getLoggingCategory();
            if ( isEnabled( logCategory ) ) {
                log( logCategory, getBodyContent().getString().trim() );
            }
        }
        return SKIP_BODY;
    }
    
    // Implementation methods
    //------------------------------------------------------------------------- 
    protected abstract boolean isEnabled(Log logCategory);
    protected abstract void log(Log logCategory, String message);
    
    protected Log getLoggingCategory() {
        if ( category == null ) {
            // used to be Category.getRoot();
            return LogFactory.getLog("");
        }
        else {
            return LogFactory.getLog( category );
        }
    }
}

