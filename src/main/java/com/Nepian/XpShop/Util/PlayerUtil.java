package com.Nepian.XpShop.Util;

import org.bukkit.entity.Player;

public class PlayerUtil {

	/**
	 * プレイヤーの総Exp量を取得する
	 * @param player
	 * @return TotalExpValue
	 */
	public static int getTotalExpValue(Player player) {
		int xp = player.getLevel();
		float exp = player.getExp();
		int expValueToXp = player.getExpToLevel();
		return XPUtil.convertXpToExpValue(xp) + XPUtil.convertExpToExpValue(xp, exp, expValueToXp);
	}
	
	/**
	 * プレイヤーのXPからXPまでに必要なExp量を取得する
	 * @param player
	 * @param difference
	 * @return
	 */
	public static int getExpValueFromXpToXp(Player player, int difference) {
		float exp = player.getExp();
		int oldXp = player.getLevel();
		int newXp = oldXp + difference;
		int oldExpValueToXp = player.getExpToLevel();
		int newExpValueToXp = XPUtil.getExpValueNeededToNextXP(newXp);
		return XPUtil.getExpValueFromXpToXp(oldXp, newXp, exp, exp, oldExpValueToXp, newExpValueToXp);
	}
}
