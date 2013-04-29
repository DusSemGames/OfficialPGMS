package com.github.PGMSOpenSource.OfficialPGMS.listeners;

import java.util.List;

import net.minecraft.server.v1_5_R2.Block;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TeamUtils;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TextUtils;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TrackingUtils;

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
			List<String> motd = plugin.getConfig().getStringList("motd");
			for(String s :motd)
			{
				p.sendMessage(s);
			}
		}
		
		TeamUtils.setObserver(p.getName());
	}

	@EventHandler
	public void PlayerLogin(PlayerLoginEvent e)
	{
		//TODO: Ban checking
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e)
	{
		//TODO:
		TeamUtils.clearPlayer(e.getPlayer().getName());
	}

	@EventHandler
	public void PlayerEnterPortal(EntityPortalEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void ChatFormat(AsyncPlayerChatEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setFormat(ChatColor.YELLOW + "[" + ChatColor.AQUA + "O" + ChatColor.YELLOW + "] " + e.getPlayer().getName() + ": " + e.getMessage()); 
		}
		else if(TeamUtils.isTeam1(e.getPlayer().getName()))
		{
			e.setFormat(ChatColor.YELLOW + "[" + ChatColor.DARK_RED + "R" + ChatColor.YELLOW + "] " + e.getPlayer().getName() + ": " + e.getMessage()); 
		}
		else if(TeamUtils.isTeam2(e.getPlayer().getName()))
		{
			e.setFormat(ChatColor.YELLOW + "[" + ChatColor.DARK_BLUE + "B" + ChatColor.YELLOW + "] " + e.getPlayer().getName() + ": " + e.getMessage()); 
		}
	}
	
	@EventHandler(ignoreCancelled=true)
	public void TNTRegistry(BlockPlaceEvent e)
	{
		if(e.getBlock().getTypeId() == 46) //TNT
		{
			String p = e.getPlayer().getName();
			TrackingUtils.trackTNTPlace(e.getBlock(), p);
		}
		else if(e.getBlock().getTypeId() == 23)//Dispenser
		{
			
		}
	}
	
	@EventHandler(ignoreCancelled=true)
	public void TNTDeRegistry(BlockBreakEvent e)
	{
		if(e.getBlock().getTypeId() == 46) //TNT
		{
			TrackingUtils.removeTNTTracking(e.getBlock());
		}
	}
	
	@EventHandler(ignoreCancelled=true)
	public void TNTIgnite(ExplosionPrimeEvent e)
	{
		if(e.getEntity() instanceof TNTPrimed)
		{
			TNTPrimed TNT = (TNTPrimed) e.getEntity();
		}
	}
	
	@EventHandler
	public void DeathFormat(PlayerDeathEvent e)
	{
		Player p = e.getEntity();
		String deathmessage = e.getDeathMessage();
		if(p.getKiller() != null && p.getKiller() instanceof Player)
		{
			Player k = p.getKiller();
			if(TeamUtils.isTeam1(k.getName()))
			{
				deathmessage = deathmessage.replace(k.getName(), ChatColor.DARK_RED + p.getName() + ChatColor.RESET);
			}
			else if(TeamUtils.isTeam2(k.getName()))
			{
				deathmessage = deathmessage.replace(k.getName(), ChatColor.DARK_BLUE + p.getName() + ChatColor.RESET);
			}
		}
		if(TeamUtils.isTeam1(p.getName()))
		{
			deathmessage = deathmessage.replace(p.getName(), ChatColor.DARK_RED + p.getName() + ChatColor.RESET);
		}
		else if(TeamUtils.isTeam2(p.getName()))
		{
			deathmessage = deathmessage.replace(p.getName(), ChatColor.DARK_BLUE + p.getName() + ChatColor.RESET);
		}
		e.setDeathMessage(deathmessage);
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
			Player p = (Player) e.getDamager();
			if(TeamUtils.isObserver(p.getName()))
			{
				if(e.getEntity() instanceof Player)
				{
					e.setCancelled(true);
					Player attacked = (Player) e.getEntity();
					if(attacked.getHealth() != 0)
					{
						p.sendMessage(ChatColor.YELLOW + attacked.getName() + " Has " + TextUtils.ColourInts(attacked.getHealth()) + "/20" + ChatColor.YELLOW + " health");
						p.sendMessage(ChatColor.YELLOW + attacked.getName() + " Has " + TextUtils.ColourInts(attacked.getFoodLevel()) + "/20" + ChatColor.YELLOW + " hunger");
						if(attacked.getActivePotionEffects().size() > 0)
						{
							for(PotionEffect pot : attacked.getActivePotionEffects())
							{
								String amp = TextUtils.numberToRoman(pot.getAmplifier() + 1);
								int duration = (pot.getDuration() / 20);
								String potion = TextUtils.NamePotions(pot.getType().getName());
								p.sendMessage(ChatColor.DARK_RED + attacked.getName() + ChatColor.YELLOW + " Has the potion effect " + ChatColor.DARK_PURPLE + potion + " " + amp + ChatColor.YELLOW +" it lasts " + ChatColor.DARK_PURPLE + duration + " seconds");
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
			if(TeamUtils.isObserver(e.getPlayer().getName()))
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
	
	@EventHandler
	public void ObserverUseContainer(InventoryClickEvent e)
	{
		if(e.getWhoClicked() instanceof Player)
		{
			Player p = (Player) e.getWhoClicked();
			if(TeamUtils.isObserver(p.getName()))
			{
			e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void ObserverInteract(PlayerInteractEvent e)
	{
		if(TeamUtils.isObserver(e.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void ObserversPotion(PotionSplashEvent e)
	{
		if(e.getPotion().getShooter() instanceof Player)
		{
			Player p = (Player) e.getPotion().getShooter();
			if(TeamUtils.isObserver(p.getName()))
			{
				e.setCancelled(true);
			}
		}
	}
}

