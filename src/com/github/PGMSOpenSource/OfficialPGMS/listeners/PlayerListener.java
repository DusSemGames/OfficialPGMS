package com.github.PGMSOpenSource.OfficialPGMS.listeners;

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
		//TODO: MOTD
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
