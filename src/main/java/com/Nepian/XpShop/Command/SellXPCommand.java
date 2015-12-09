package com.Nepian.XpShop.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Nepian.XpShop.EventManager;
import com.Nepian.XpShop.Event.SellXPEvent;

public class SellXPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}
		
		if (args.length != 1) {
			return false;
		}
		
		Player player = (Player) sender;
		int sellAmount = Integer.valueOf(args[0]);
		
		SellXPEvent event = new SellXPEvent(player, sellAmount);
		
		EventManager.callEvent(event);
		
		return true;
	}

}
