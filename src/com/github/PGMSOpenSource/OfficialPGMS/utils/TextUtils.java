package com.github.PGMSOpenSource.OfficialPGMS.utils;

import org.bukkit.ChatColor;

public class TextUtils
{

	public static String colourInts(int i)
	{
		if(i > 13)
		{
			return ChatColor.GREEN + "" + i;
		}
		else if(i > 6 && i < 14)
		{
			return ChatColor.GOLD + "" + i;
		}
		else
		{
			return ChatColor.RED + "" + i;
		}
		
	}
}
