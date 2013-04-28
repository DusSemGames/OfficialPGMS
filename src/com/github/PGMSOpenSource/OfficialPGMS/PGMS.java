package com.github.PGMSOpenSource.OfficialPGMS;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.PGMSOpenSource.OfficialPGMS.listeners.JoinListener;
import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;

public class PGMS extends JavaPlugin {
	
	public static PGMS plugin;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		init();
		getConfig().options().copyDefaults();
		saveConfig();
		
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinListener(this), this);
	}
	
	public void init() {
		new PGMSLogger(this);
	}

}
