package me.benfah.bags.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.benfah.bags.main.Bags;

public class Util {

	public static String standardLink = "https://www.dropbox.com/s/kllx5y7aqv5x317/Bags2.zip?dl=1";
	
	public static boolean isUnbreakableAndHasDamage(ItemStack stack, short damage)
	{
		if(stack.getItemMeta().spigot().isUnbreakable())
		if(stack.getDurability() == damage)
		return true;
		return false;
	}
	
	public static void sendRequest(Player p)
	{
		if(Bags.cfg.getBoolean("custom-resourcepack"))
		{
			p.setResourcePack(Bags.cfg.getString("custom-resourcepack-link"));
		}
		else
		p.setResourcePack(standardLink);
	}
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
	    return false;
	}
}
