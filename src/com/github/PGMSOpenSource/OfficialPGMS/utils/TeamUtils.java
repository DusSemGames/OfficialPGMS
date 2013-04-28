package com.github.PGMSOpenSource.OfficialPGMS.utils;

import java.util.ArrayList;
import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class TeamUtils 
{
	private PGMS plugin;
	public TeamUtils(PGMS instance)
	{
		plugin = instance;
	}
	//TODO: Allow > 2 teams, handle teams via Start/End/Load Game
	private static ArrayList<String> team1 = new ArrayList<String>();
	private static ArrayList<String> team2 = new ArrayList<String>();
	private static ArrayList<String> observers = new ArrayList<String>();
	
	public static boolean isObserver(String s)
	{
		return observers.contains(s);
	}
	
	public static boolean isTeam1(String s)
	{
		return team1.contains(s);
	}
	
	public static boolean isTeam2(String s)
	{
		return team2.contains(s);
	}
	
	public static void setObserver(String s)
	{
		observers.add(s);
	}
	
}
