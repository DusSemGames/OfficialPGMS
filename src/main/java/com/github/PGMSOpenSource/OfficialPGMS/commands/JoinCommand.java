package com.github.PGMSOpenSource.OfficialPGMS.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.PGMSOpenSource.OfficialPGMS.PGMS;
import com.github.PGMSOpenSource.OfficialPGMS.utils.TeamUtils;

public class JoinCommand implements CommandExecutor
{
	private PGMS plugin;

	public JoinCommand(PGMS instance)
	{
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			if(args.length == 1)
			{
				if(args[0].equalsIgnoreCase("red"))
				{
					if(TeamUtils.setTeam1(p.getName()))
					{
						p.sendMessage("You have successfully joined the " + ChatColor.DARK_RED + " Red team");
						return true;
					}
					else
					{
						p.sendMessage("You could not join Red team at this time");
						return false;
					}
				}
				else if(args[0].equalsIgnoreCase("blue"))
				{
					if(TeamUtils.setTeam2(p.getName()))
					{
						p.sendMessage("You have successfully joined the " + ChatColor.DARK_BLUE + " Blue team");
						return true;
					}
					else
					{
						p.sendMessage("You could not join blue team at this time");
						return false;
					}
				}
				else if(args[0].equalsIgnoreCase("obs"))
				{
					if(TeamUtils.setObserver(p.getName()))
					{
						p.sendMessage("You have successfully joined the " + ChatColor.AQUA + " Observers");
						return true;
					}
					else
					{
						p.sendMessage("You could not join observers at this time");
						return false;
					}
				}
					return false;
			}
			if(TeamUtils.getTeam1Size() > TeamUtils.getTeam2Size())
			{
				if(TeamUtils.setTeam2(p.getName()))
				{
					p.sendMessage("You have successfully joined the " + ChatColor.DARK_BLUE + "Blue team");
					return true;
				}
				else
				{
					p.sendMessage("You could not join a team");
					return false;
				}
			}
			else
			{
				if(TeamUtils.setTeam1(p.getName()))
				{
					p.sendMessage("You have successfully joined the " + ChatColor.DARK_RED + "Red team");
					return true;
				}
				else
				{
					p.sendMessage("You could not join a team");
					return false;
				}
			}
		}
		return true;
	}
}
