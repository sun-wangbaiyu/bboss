/*
 *  Copyright 2008 bbossgroups
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.frameworkset.web.token;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.frameworkset.common.tag.BaseTag;

/**
 * <p>Title: AssertDTokenTag.java</p> 
 * <p>Description: </p>
 * <p>bboss workgroup</p>
 * <p>Copyright (c) 2008</p>
 * @Date 2012-8-24
 * @author biaoping.yin
 * @version 3.6
 */
public class AssertDTokenTag extends BaseTag{

	@Override
	public void doFinally() {
		// TODO Auto-generated method stub
		super.doFinally();
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		int ret = super.doStartTag();
		
		MemTokenManager memTokenManager = MemTokenManagerFactory.getMemTokenManagerNoexception();
		if(memTokenManager == null)
			return ret;
		try {
			memTokenManager.doDTokencheck(request, response);
		} catch (IOException e) {
			throw new JspException(e);
		} catch (DTokenValidateFailedException e) {
			throw new JspException(e);
		}
		return ret;
	}

}
