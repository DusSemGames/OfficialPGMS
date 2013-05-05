package com.github.PGMSOpenSource.OfficialPGMS.utils;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

public class WorldUtils {
	//Mah beautiful utility classes - skipperguy12

	public void unloadMap(String mapname) {
		if (Bukkit.getServer().unloadWorld(
				Bukkit.getServer().getWorld(mapname), false)) {
			PGMSLogger.log("Unloaded world: " + mapname);
		} else {
			PGMSLogger.log("warning", "Could not unload: " + mapname);
		}
	}

	public void loadMap(String mapname) {
		Bukkit.getServer().createWorld(new WorldCreator(mapname));
	}

	public void rollback(String mapname) {
		unloadMap(mapname);
		loadMap(mapname);
	}

}
