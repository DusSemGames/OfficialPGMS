package com.github.PGMSOpenSource.OfficialPGMS.utils;

import java.util.HashMap;

import org.bukkit.block.Block;
import org.bukkit.entity.TNTPrimed;

public class TrackingUtils 
{
	private static HashMap<Block, String> TNTBlockTracker = new HashMap<Block, String>();
	private static HashMap<TNTPrimed, String> TNTEntityTracker = new HashMap<TNTPrimed, String>();
	
	public static void trackTNTPlace(Block b, String s)
	{
		TNTBlockTracker.put(b, s);
	}
	
	public static void removeTNTTracking(Block b)
	{
		if(TNTBlockTracker.containsKey(b))
		{
			TNTBlockTracker.remove(b);
		}
	}
}
