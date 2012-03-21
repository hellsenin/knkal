package com.uro.common.base;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.uro.common.util.StringUtil;





/**
 * A Map that converts all keys to lowercase Strings for case insensitive
 * lookups. This is needed for the toMap() implementation because databases
 * don't consistenly handle the casing of column names.
 */
public class CiHashMap extends HashMap implements DbMap {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2842877277470561984L;

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return super.containsKey(key.toString().toLowerCase());
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(Object key) {
		 
		Object obj = super.get(key.toString().toLowerCase());
//		if(obj instanceof CLOB){
//			obj = getStringForCLOB((CLOB)obj);
//		}
		return obj;
	}

	/**
	 * �Ʒ� �޼ҵ���� Ÿ���½����ϴ� ������ ���ֱ� ���� �߰���.
	 * 
	 * @param key
	 * @return
	 */
	public String getString(Object key) {
		
		Object obj = super.get(key.toString().toLowerCase());
		if ( obj !=null) {
			return obj.toString();
		}
		
		return "";
	}

	public int getInt(Object key) {
		Object op = super.get(key.toString().toLowerCase());
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).intValue();
		} else if (op instanceof Integer) {
			return ((Integer) (op)).intValue();
		} else {
			return 0;
		}
	}

	public long getLong(Object key) {
		Object op = super.get(key.toString().toLowerCase());
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).longValue();
		} else if (op instanceof Long) {
			return ((Long) (op)).longValue();
		} else {
			return 0;
		}

	}

	public float getFloat(Object key) {
		Object op = super.get(key.toString().toLowerCase());
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).floatValue();
		} else if (op instanceof Float) {
			return ((Float) (op)).floatValue();
		} else {
			return 0;
		}
	}

	public double getDouble(Object key) {
		Object op = super.get(key.toString().toLowerCase());
		if (op instanceof BigDecimal) {
			return ((BigDecimal) (op)).doubleValue();
		} else if (op instanceof Double) {
			return ((Double) (op)).doubleValue();
		} else {
			return 0;
		}

	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object key, Object value) {
		//user_id     userId
	
		return super.put(StringUtil.removeCharacter(key.toString().toLowerCase().trim(),'_'), value);
		
//		java.util.regex.Pattern patt = java.util.regex.Pattern.compile("\\_(\\w)");
//		java.util.regex.Matcher m = patt.matcher(key.toString().toLowerCase());
//		StringBuffer sb = new StringBuffer(key.toString().length());
//		while (m.find()) {
//		  String text = m.group(1);
//		  text = text.toUpperCase();
//		  m.appendReplacement(sb, java.util.regex.Matcher.quoteReplacement(text));
//		}
//		m.appendTail(sb);
//		return (super.put(sb.toString(), value));
		
	}


	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map m) {
		Iterator iter = m.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			Object value = m.get(key);
			this.put(key, value);
		}
	}

	/**
	 * @see java.util.Map#remove(java.lang.ObjecT)
	 */
	public Object remove(Object key) {
		return super.remove(key.toString().toLowerCase());
	}
	
	
//	public static String getStringForCLOB(CLOB clob) {
//        
//        StringBuffer sbf = new StringBuffer();
//        Reader br = null;
//        char[] buf = new char[1024];
//        int readcnt;
//
//        try {
//            br = clob.getCharacterStream(0L);
//
//            while ((readcnt=br.read(buf,0,1024))!=-1) {
//                sbf.append(buf,0,readcnt);
//            }
//
//        } catch (Exception e) {
//           
//        }finally{
//            if(br!=null)
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    
//               }
//        }
//        return sbf.toString();
//    } 

	public String toStringCheck() throws InnoException {
		String str = "";
		Iterator it = super.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = super.get(key);
			String op="";
			if( value instanceof String[]){
				for( int r = 0; r < ((String[])value).length ; r++){
					op += ((String[])value)[r];
				}
			}
			else{
			    op = value.toString();
			}
			int p = op.indexOf('\'');
			if( p >= 0) {
				throw new InnoException("�Է��ʵ忡 ' �� ����Ҽ� ����ϴ�.");
			}
			str += "["+key +" > "+ op +"]";
		}
		
		return str;
	}

	public String toString()  {
		String str = "";
		Iterator it = super.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = super.get(key);
			String op="";
			if( value instanceof String[]){
				for( int r = 0; r < ((String[])value).length ; r++){
					op += ((String[])value)[r];
				}
			}
			else{
				if(value == null) value = "���� ����ϴ�.";
			    op = value.toString();
			}

			str += "["+key +" > "+ op +"]";
		}
		
		return str;
	}

}