package com.github.PGMSOpenSource.OfficialPGMS.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;

public class PlayerListener implements Listener
{
	private PGMS plugin;
	
	public PlayerListener(PGMS instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		if(plugin.getConfig().contains("motd"))
		{
			p.sendMessage(plugin.getConfig().getString("motd"));
		}
	}
	
	@EventHandler
	public void PlayerLogin(PlayerLoginEvent e)
	{
		//TODO: Ban checking
	}
	
	public void PlayerQuit(PlayerQuitEvent e)
	{
		//TODO:
		//Remove player from any lists etc.
	}
	
}
