package com.Nepian.XpShop;

import org.bukkit.command.CommandExecutor;

import com.Nepian.XpShop.Command.BuyXPCommand;
import com.Nepian.XpShop.Command.SellXPCommand;

public class CommandManager {
	private static Main plugin;
	
	static {
		plugin = Main.getPlugin();
	}
	
	public static void load() {
		registerCommand("buyxp", new BuyXPCommand());
		registerCommand("sellxp", new SellXPCommand());
	}
	
	private static void registerCommand(String name, CommandExecutor cmd) {
		plugin.getCommand(name).setExecutor(cmd);
	}
}
