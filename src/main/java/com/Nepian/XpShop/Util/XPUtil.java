package com.Nepian.XpShop.Util;

public class XPUtil {
	
	/**
	 * XPをExp量に変換する
	 * @param xp
	 * @return ExpValue
	 */
	public static int convertXpToExpValue(int xp) {
		if (xp >= 30) return (int) (3.5 * xp * xp - 151.5 * xp + 2220);
		if (xp >= 16) return (int) (1.5 * xp * xp - 29.5 * xp + 360);
		if (xp >= 0)  return 17 * xp;
		return 0;
	}
	
	/**
	 * 次のXPレベルまでに必要なExp量を取得する
	 * @param xp
	 * @return ExpValue
	 */
	public static int getExpValueNeededToNextXP(int xp) {
		if (xp >= 30) return 62 + (xp - 30) * 7;
		if (xp >= 15) return 17 + (xp - 15) * 3;
		if (xp >= 0)  return 17;
		return 0;
	}
	
	/**
	 * XPとXPのExp量の差を求める
	 * @param oldXP
	 * @param newXP
	 * @return ExpValue
	 */
	public static int getExpValueFromXpToXp(int oldXP, int newXP) {
		int oldExpValue = convertXpToExpValue(oldXP);
		int newExpValue = convertXpToExpValue(newXP);
		return newExpValue - oldExpValue;
	}

	/**
	 * ExpをExp量に変換する
	 * @param xp
	 * @param exp
	 * @param expValueToXp 次のレベルまでに必要なExp量
	 * @return ExpValue
	 */
	public static int convertExpToExpValue(int xp, float exp, int expValueToXp) {
		return Math.round(expValueToXp * exp);
	}
	
	/**
	 * XPからXPまでに必要なExpValueを求める
	 * @param oldXp
	 * @param newXp
	 * @param oldExp
	 * @param newExp
	 * @param oldExpValueToXp
	 * @param newExpValueToXp
	 * @return
	 */
	public static int getExpValueFromXpToXp(int oldXp, int newXp, float oldExp, float newExp,
			int oldExpValueToXp, int newExpValueToXp) {
		int oldExpValue = getTotalExpValue(oldXp, oldExp, oldExpValueToXp);
		int newExpValue = getTotalExpValue(newXp, newExp, newExpValueToXp);
		return Math.abs(newExpValue - oldExpValue);
	}
	
	/**
	 * 総Exp量を求める
	 * @param xp
	 * @param exp
	 * @param expValueToXp
	 * @return
	 */
	public static int getTotalExpValue(int xp, float exp, int expValueToXp) {
		return convertXpToExpValue(xp) + convertExpToExpValue(xp, exp, expValueToXp);
	}
}
