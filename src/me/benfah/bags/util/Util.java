package me.benfah.bags.util;

import org.bukkit.inventory.ItemStack;

public class Util {

	
	
	
	public static boolean isUnbreakableAndHasDamage(ItemStack stack, short damage)
	{
		
		if(stack.getItemMeta().spigot().isUnbreakable())
		if(stack.getDurability() == damage)
		return true;
			

		return false;
	
		
	}
	
	
	
	
	
	
}
