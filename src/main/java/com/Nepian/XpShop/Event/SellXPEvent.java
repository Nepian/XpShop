package com.Nepian.XpShop.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Nepian.XpShop.Configuration.Config;
import com.Nepian.XpShop.Util.PlayerUtil;

public class SellXPEvent extends Event {
	private static HandlerList handlers = new HandlerList();
	
	private Outcome outcome;
	private Player player;
	private int sellAmount;
	private double price;
	
	public SellXPEvent(Player player, int sellAmount) {
		this.outcome = Outcome.SUCCESS;
		this.player = player;
		this.sellAmount = sellAmount;
		this.price = this.setPrice(player, sellAmount);
	}
	
	public boolean isCancelled() {
		return this.outcome != Outcome.SUCCESS;
	}
	
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getSellAmount() {
		return this.sellAmount;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

	public enum Outcome {
		SUCCESS,
		
		NO_XP;
	}
	
	private double setPrice(Player player, int amount) {
		int expValue = PlayerUtil.getExpValueFromXpToXp(player, amount * -1);
		return expValue * Config.SELL_EXP_RATE.getInt();
	}
}
