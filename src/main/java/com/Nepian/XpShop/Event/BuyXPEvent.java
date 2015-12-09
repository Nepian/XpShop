package com.Nepian.XpShop.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.Nepian.XpShop.Configuration.Config;
import com.Nepian.XpShop.Util.PlayerUtil;

public class BuyXPEvent extends Event {
	private static HandlerList handlers = new HandlerList();
	
	private Outcome outcome;
	private Player player;
	private int buyAmount;
	private double price;
	
	public BuyXPEvent(Player player, int buyAmount) {
		this.outcome = Outcome.SUCCESS;
		this.player = player;
		this.buyAmount = buyAmount;
		this.price = this.setPrice(player, buyAmount);
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
	
	public int getBuyAmount() {
		return this.buyAmount;
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
		
		NO_MONEY;
	}
	
	private double setPrice(Player player, int amount) {
		int expValue = PlayerUtil.getExpValueFromXpToXp(player, amount);
		return expValue * Config.BUY_EXP_RATE.getInt();
	}
}
