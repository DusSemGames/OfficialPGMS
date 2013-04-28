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
					TeamUtils.setTeam1(p.getName());
					p.sendMessage("You have successfully joined the " + ChatColor.DARK_RED + " red team");
					return true;
				}
				else if(args[0].equalsIgnoreCase("blue"))
				{
					TeamUtils.setTeam2(p.getName());
					p.sendMessage("You have successfully joined the " + ChatColor.DARK_BLUE + " blue team");
					return true;
				}
				else if(args[0].equalsIgnoreCase("obs"))
				{
					TeamUtils.setObserver(p.getName());
					p.sendMessage("You have successfully joined the " + ChatColor.AQUA + " observers");
					return true;
				}
					return false;
			}
			if(TeamUtils.getTeam1Size() > TeamUtils.getTeam2Size())
			{
				TeamUtils.setTeam2(p.getName());
				p.sendMessage("You have successfully joined the " + ChatColor.DARK_BLUE + "blue team");
				return true;
			}
			else
			{
				TeamUtils.setTeam1(p.getName());
				p.sendMessage("You have successfully joined the " + ChatColor.DARK_RED + "red team");
				return true;
			}
		}
		return true;
	}
}
