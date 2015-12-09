package com.Nepian.XpShop.Listener.SellXp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.Nepian.XpShop.Event.SellXPEvent;
import com.Nepian.XpShop.Event.SellXPEvent.Outcome;

public class SxpXpChecker implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public static void onSxp(SellXPEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		int amount = event.getSellAmount();
		int xp = player.getLevel();
		
		if (xp < amount) {
			event.setOutcome(Outcome.NO_XP);
			player.sendMessage("You don't have enough XP");
		}
	}
}
