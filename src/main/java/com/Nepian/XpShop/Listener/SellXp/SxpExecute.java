package com.Nepian.XpShop.Listener.SellXp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.XpShop.Eco;
import com.Nepian.XpShop.Event.SellXPEvent;

public class SxpExecute implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public static void onSxp(SellXPEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		int amount = event.getSellAmount();
		double price = event.getPrice();
		
		player.giveExpLevels(amount * -1);
		Eco.getEconomy().depositPlayer(player, price);
		
		player.sendMessage("You have succeeded in selling XP");
	}
}
