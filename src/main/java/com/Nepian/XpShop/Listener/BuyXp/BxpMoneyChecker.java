package com.Nepian.XpShop.Listener.BuyXp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.XpShop.Eco;
import com.Nepian.XpShop.Event.BuyXPEvent;
import com.Nepian.XpShop.Event.BuyXPEvent.Outcome;

public class BxpMoneyChecker implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public static void onBxp(BuyXPEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		double price = event.getPrice();
		double money = Eco.getEconomy().getBalance(player);
		
		if (money < price) {
			event.setOutcome(Outcome.NO_MONEY);
			player.sendMessage("You don't have enough money.");
		}
	}
}
