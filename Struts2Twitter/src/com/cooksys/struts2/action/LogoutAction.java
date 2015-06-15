package com.cooksys.struts2.action;

import com.cooksys.util.Util;
import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action
{
	public String execute()
	{
		Util.setCurrentUserId(null);
		Util.setCurrentUsername(null);
		return SUCCESS;
	}
}
