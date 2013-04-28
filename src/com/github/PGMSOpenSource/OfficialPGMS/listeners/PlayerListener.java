package com.github.PGMSOpenSource.OfficialPGMS.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TeamUtils;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TextUtils;

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
			for(String s : plugin.getConfig().getStringList("motd"))
			{
				s = s.replaceAll("&", "§");
				p.sendMessage(s);
			}
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

	public void PlayerEnterPortal(EntityPortalEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			e.setCancelled(true);
		}
	}

	/*
	 * HANDLE OBSERVER STUFF HERE
	 */

	@EventHandler
	public void ObserverPlaceBlock(BlockPlaceEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void ObserverBreakBlock(BlockBreakEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void ObserverDamage(EntityDamageByEntityEvent e)
	{
		if(e.getDamager() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if(TeamUtils.isObserver(p.getName()))
			{
				if(e.getEntity() instanceof Player)
				{
					e.setCancelled(true);
					Player attacked = (Player) e.getEntity();
					if(attacked.getHealth() != 0)
					{
						p.sendMessage(ChatColor.YELLOW + attacked.getName() + " Has " + TextUtils.colourInts(attacked.getHealth()) + "/20" + ChatColor.YELLOW + " health");
						p.sendMessage(ChatColor.YELLOW + attacked.getName() + " Has " + TextUtils.colourInts(attacked.getFoodLevel()) + "/20" + ChatColor.YELLOW + " hunger");
						if(attacked.getActivePotionEffects().size() > 0)
						{
							for(PotionEffect pot : attacked.getActivePotionEffects())
							{
								p.sendMessage(ChatColor.YELLOW + p.getName() + "Has the potion effect " + pot.getType().getName() + " " + (pot.getAmplifier() + 1) + "it lasts " + pot.getDuration());
							}
						}
					}
					else
					{
						p.sendMessage(ChatColor.GOLD + "It seems that player is dead!");
					}
				}
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void ObserverShootBow(EntityShootBowEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if(TeamUtils.isObserver(p.getName()))
			{
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void ObserverThrowItem(PlayerDropItemEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void ObserverSeePlayersInventory(PlayerInteractEntityEvent e)
	{
		if(e.getRightClicked() instanceof Player)
		{
			Player p = (Player) e.getRightClicked();
			if(TeamUtils.isObserver(e.getPlayer().getName()) && !TeamUtils.isObserver(p.getName()))
			{
				e.getPlayer().openInventory(p.getInventory());
			}
		}
	}
	
	@EventHandler
	public void ObserverPickupItem(PlayerPickupItemEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
	}
}

