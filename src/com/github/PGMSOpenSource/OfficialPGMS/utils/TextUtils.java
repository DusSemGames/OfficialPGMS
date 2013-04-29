package com.github.PGMSOpenSource.OfficialPGMS.utils;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

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
			return "Strength";
		else if(s.equalsIgnoreCase("slow"))
			return "Slowness";
		else if(s.equalsIgnoreCase("fast digging"))
			return "Haste";
		else if(s.equalsIgnoreCase("damage resistance"))
			return "Resistance";
		else if(s.equalsIgnoreCase("heal"))
			return "Instant Heal";
		else
			return WordUtils.capitalize(s);
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
	
	public static String colourName(String name)
	{
		if(TeamUtils.isTeam1(name))
		{
			name = name.replace(name, ChatColor.DARK_RED + name);
			return name;
		}
		else if(TeamUtils.isTeam2(name))
		{
			name = name.replace(name, ChatColor.DARK_BLUE + name);
			return name;
		}
		else
		{
			name = name.replace(name, ChatColor.AQUA + name);
			return name;
		}
	}
}
