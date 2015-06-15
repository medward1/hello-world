package com.cooksys.util;

public class Util
{
	private static Integer currentUserId;
	private static String currentUsername;
	
	public static Integer getCurrentUserId()
	{
		return currentUserId;
	}
	public static void setCurrentUserId(Integer currentUserId)
	{
		Util.currentUserId = currentUserId;
	}
	public static String getCurrentUsername()
	{
		return currentUsername;
	}
	public static void setCurrentUsername(String currentUsername)
	{
		Util.currentUsername = currentUsername;
	}
}
