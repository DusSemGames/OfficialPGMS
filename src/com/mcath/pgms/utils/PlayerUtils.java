package com.mcath.pgms.utils;

import org.bukkit.entity.Player;

public class PlayerUtils {
		//Mah beautiful utility classes - skipperguy12

	@SuppressWarnings("deprecation")
	public static void resetPlayer(Player player, boolean resetInventory) {
		if (player == null) {
			return;
		}
		player.setHealth(20);
		player.setSaturation(20.0F);
		player.setExhaustion(20.0F);
		player.setFireTicks(0);
		player.setFoodLevel(20);
		player.setExp(0.0F);
		player.setLevel(0);
		player.setSneaking(false);
		player.setSprinting(false);
		player.setFallDistance(0.0F);
		if (resetInventory) {
			player.getInventory().clear();
			player.getInventory().setArmorContents(null);
			player.updateInventory();
		}
	}

}
