package com.mcath.pgms;

import org.bukkit.plugin.java.JavaPlugin;

import com.mcath.pgms.utils.PGMSLogger;

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
