package com.github.PGMSOpenSource.OfficialPGMS.utils;

import org.bukkit.ChatColor;

public class TextUtils
{

	public static String ColourInts(int i)
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
	
	public static String NamePotions(String s)
	{
		s = s.toLowerCase();
		s = s.replace("_", " ");
		if(s.equalsIgnoreCase("increase damage"))
			return "strength";
		else if(s.equalsIgnoreCase("slow"))
			return "slowness";
		else if(s.equalsIgnoreCase("fast digging"))
			return "haste";
		else if(s.equalsIgnoreCase("damage resistance"))
			return "resistance";
		else if(s.equalsIgnoreCase("heal"))
			return "instant heal";
		else
			return s;
	}
	
	public static String numberToRoman(int i)
	{
		switch(i)
		{
		case 1:
			return "I";
		case 2:
			return "II";
		case 3:
			return "III";
		case 4:
			return "IV";
		case 5:
			return "V";
		default:
			return Integer.toString(i);
		}
	}
}
