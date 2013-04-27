package com.github.PGMSOpenSource.OfficialPGMS.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class JoinEvent implements Listener {
	
	PGMS plugin;
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e){
		Player player = e.getPlayer();
		player.sendMessage(plugin.getConfig().getString("motd"));
	}
}
