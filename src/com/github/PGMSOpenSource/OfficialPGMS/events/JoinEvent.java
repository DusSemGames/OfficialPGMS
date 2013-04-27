package com.github.PGMSOpenSource.OfficialPGMS.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class JoinEvent implements Listener {
	
	private PGMS plugin;
	
	public JoinEvent(PGMS instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e){
		Player player = e.getPlayer();
		if(plugin.getConfig().contains("motd")) {
			player.sendMessage(plugin.getConfig().getString("motd"));
		}
	}
}
