package com.github.PGMSOpenSource.OfficialPGMS.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationParser {
	//Mah beautiful utility classes - skipperguy12

	public static String locToString(Location l, int x, int y, int z, float f,
			float g) {
		String location = (l.getWorld().getName() + ":" + l.getX() + ":"
				+ l.getY() + ":" + l.getZ() + ":" + f + ":" + g);
		return location;
	}

	public static Location stringToLoc(String s) {
		String[] loc = s.split(":");
		World world = Bukkit.getWorld(loc[0]);
		double x = Double.parseDouble(loc[1]);
		double y = Double.parseDouble(loc[2]);
		double z = Double.parseDouble(loc[3]);
		double yaw = Double.parseDouble(loc[4]);
		double pitch = Double.parseDouble(loc[5]);
		Location finalloc = new Location(world, x, y, z);
		finalloc.setPitch((float) pitch);
		finalloc.setYaw((float) yaw);
		return finalloc;
	}

}
