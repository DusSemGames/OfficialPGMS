package com.github.PGMSOpenSource.OfficialPGMS.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class JoinEvent implements Listener {
	
	private PGMS plugin;
	
	public JoinEvent(PGMS instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		String motd = plugin.getConfig().getString("motd");
		motd = motd.replaceAll("&", "§");
		player.sendMessage(motd);
	}
}
