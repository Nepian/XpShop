package com.Nepian.XpShop;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import com.Nepian.XpShop.Listener.BuyXp.BxpExecute;
import com.Nepian.XpShop.Listener.BuyXp.BxpMoneyChecker;
import com.Nepian.XpShop.Listener.SellXp.SxpExecute;
import com.Nepian.XpShop.Listener.SellXp.SxpXpChecker;

public class EventManager {
	private static final Main plugin;

	static {
		plugin = Main.getPlugin();
	}

	public static void load() {
		registerBuyXPEvent();
		registerSellXPEvent();
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}

	private static void registerEvent(Listener listener) {
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	
	private static void registerBuyXPEvent() {
		registerEvent(new BxpMoneyChecker());	//priority = LOW
		registerEvent(new BxpExecute());		//prioriry = NORMAL
	}
	
	private static void registerSellXPEvent() {
		registerEvent(new SxpXpChecker());	//priority = LOW
		registerEvent(new SxpExecute());	//priority = NORMAL
	}
}
