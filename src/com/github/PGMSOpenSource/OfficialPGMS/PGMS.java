package com.github.PGMSOpenSource.OfficialPGMS;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.PGMSOpenSource.OfficialPGMS.events.JoinEvent;
import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;

public class PGMS extends JavaPlugin {
	
	public static PGMS plugin;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		init();
		getConfig().options().copyDefaults();
		saveConfig();
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
	}
	
	public void init() {
		new PGMSLogger(this);
	}

}
