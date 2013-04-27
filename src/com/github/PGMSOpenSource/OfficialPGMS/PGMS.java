package com.github.PGMSOpenSource.OfficialPGMS;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;

public class PGMS extends JavaPlugin {
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		init();
	}
	
	public void init() {
		new PGMSLogger(this);
	}

}
