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
	
	public static boolean setObserver(String s)
	{
		if(isTeam1(s))
		{
			team1.remove(s);
		}
		else if(isTeam2(s))
		{
			team2.remove(s);
		}
		observers.add(s);
		return true;
	}
	
	public static boolean setTeam1(String s)
	{
		if(isTeam2(s))
			return false;
		else if(isTeam1(s))
			return false;
		else if(isObserver(s))
		{
			observers.remove(s);
			team1.add(s);
			return true;
		}
		return false;
	}
	
	public static boolean setTeam2(String s)
	{
		if(isTeam1(s))
		{
			return false;
		}
		else if(isTeam2(s))
			return false;
		else if(isObserver(s))
		{
			observers.remove(s);
			team2.add(s);
			return true;
		}
		return false;
	}
	
	public static int getTeam1Size()
	{
		return team1.size();
	}
	
	public static int getTeam2Size()
	{
		return team2.size();
	}
	
	public static void clearPlayer(String s)
	{
		if(team1.contains(s))
			team1.remove(s);
		if(team2.contains(s))
			team2.remove(s);
		if(observers.contains(s))
			observers.remove(s);
	}
	
	
}
