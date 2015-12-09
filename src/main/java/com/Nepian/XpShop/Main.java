package com.Nepian.XpShop;

import org.bukkit.plugin.java.JavaPlugin;

import com.Nepian.XpShop.Configuration.Config;

public class Main extends JavaPlugin {
	private static Main plugin;
	
	public Main() {
		plugin = this;
	}
	
	@Override
	public void onEnable() {
		Config.load();
		EventManager.load();
		CommandManager.load();
	}
	
	@Override
	public void onDisable() {
		Config.save();
		getServer().getScheduler().cancelTasks(this);
	}
	
	public static Main getPlugin() {
		return plugin;
	}
}
