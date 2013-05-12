package com.github.PGMSOpenSource.OfficialPGMS;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.PGMSOpenSource.OfficialPGMS.commands.JoinCommand;
import com.github.PGMSOpenSource.OfficialPGMS.listeners.PlayerListener;
import com.github.PGMSOpenSource.OfficialPGMS.utils.PGMSLogger;

public class PGMS extends JavaPlugin {
	
	public static PGMS plugin;
	
	public void onDisable() {
		
	}
	
	public void onEnable() {
		plugin = this;
		init();
		RegisterEvents();
		this.getCommand("join").setExecutor(new JoinCommand(plugin));
	}
	
	public void RegisterEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
	}
	
	public void init() {
	        new PGMSLogger(this);
	}

}
