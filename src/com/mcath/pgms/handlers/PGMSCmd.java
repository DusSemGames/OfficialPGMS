package com.mcath.pgms.handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PGMSCmd implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			return onPlayerCmd(player, command, args);
			
		} else {
			return onConsoleCmd(sender, command, args);
		}

	}

	public abstract boolean onPlayerCmd(Player player, Command command,
			String[] args);

	public abstract boolean onConsoleCmd(CommandSender console,
			Command command, String[] args);
	
	//Not in use
	public abstract boolean onCmd(CommandSender console, Command command,
			String[] args);

}
