package me.benfah.bags.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.util.Util;

public class CraftListener implements Listener{

	@EventHandler
	public void onCraftItem(CraftItemEvent e)
	{
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 10))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.small", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 11))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.big", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}	
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 12))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.enchant", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}	
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 13))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.crafting", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}	
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 14))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.ender", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}
		if(Util.isUnbreakableAndHasDamage(e.getInventory().getResult(), (short) 15))
		{
			if(!e.getWhoClicked().hasPermission(new Permission("bag.craft.anvil", PermissionDefault.TRUE)))
			{
				
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(Bags.not_allowed);
			}
		}	
	}
}
