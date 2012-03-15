/*
 * Created on Apr 19, 2005
 *
 * Copyright 2005 Kim Hyon-Sok. All rights reserved.
 * PRIVATE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.uro.common.base;

import java.util.Map;

/**
 * @author pado
 *
 */
public interface DbMap  {
	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key);

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Object get(Object key);


	public String getString(Object key);

	public int getInt(Object key);

	public long getLong(Object key);

	public float getFloat(Object key);

	public double getDouble(Object key);

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object key, Object value);

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map m);

	/**
	 * @see java.util.Map#remove(java.lang.ObjecT)
	 */
	public Object remove(Object key);
}