package com.Nepian.XpShop.Listener.BuyXp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.XpShop.Eco;
import com.Nepian.XpShop.Event.BuyXPEvent;

public class BxpExecute implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public static void onBxp(BuyXPEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		int amount = event.getBuyAmount();
		double price = event.getPrice();
		
		player.giveExpLevels(amount);
		Eco.getEconomy().withdrawPlayer(player, price);
		
		player.sendMessage("You have succeeded in buying XP");
	}
}
