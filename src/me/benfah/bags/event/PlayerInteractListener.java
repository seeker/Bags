package me.benfah.bags.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.Util;

public class PlayerInteractListener implements Listener{
	final Permission bag_open_small = new Permission("bag.open.small", PermissionDefault.NOT_OP);
	final Permission bag_open_big = new Permission("bag.open.big", PermissionDefault.NOT_OP);
	final Permission bag_open_enchant = new Permission("bag.open.enchant", PermissionDefault.NOT_OP);
	final Permission bag_open_crafting = new Permission("bag.open.crafting", PermissionDefault.NOT_OP);
	final Permission bag_open_ender = new Permission("bag.open.ender", PermissionDefault.NOT_OP);
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		
			Player p = e.getPlayer();
			ItemStack h = p.getItemInHand();
				if((h.getType() == Material.STONE_SWORD))
				{
					if(Util.isUnbreakableAndHasDamage(h, (short) 10))
					{

						if(h.getItemMeta().hasLore())
						{
							if(p.hasPermission(bag_open_small))
							{
								String ints = h.getItemMeta().getLore().iterator().next();
								int id = Integer.parseInt(ints);
								Inventory inv = BagManager.bag.get(id) != null ? ((Inventory) BagManager.bag.get(id)[0]) : Bukkit.createInventory(p, 27, "Bag");
								
								p.openInventory(inv);
								BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							}
							
							
						}
						else
						{
							
							ItemMeta hm = h.getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add("" + (Bags.cfg.getInt("bagid") + 1));
							Bags.cfg.set("bagid",	Bags.cfg.getInt("bagid") + 1);
							hm.setLore(lore);
							h.setItemMeta(hm);
							
						}
							
							
							
							
							
					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 11))
					{

						if(h.getItemMeta().hasLore())
						{
							if(p.hasPermission(bag_open_big))
							{
								String ints = h.getItemMeta().getLore().iterator().next();
								int id = Integer.parseInt(ints);
								Inventory inv = BagManager.bag.get(id) != null ? (Inventory) BagManager.bag.get(id)[0] : Bukkit.createInventory(p, 54, "Bag");
								
								p.openInventory(inv);
								BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							}
							
							
						}
						else
						{
							
							ItemMeta hm = h.getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add("" + (Bags.cfg.getInt("bagid") + 1));
							Bags.cfg.set("bagid",	Bags.cfg.getInt("bagid") + 1);
							hm.setLore(lore);
							h.setItemMeta(hm);
						}
							
							
							
							
							
					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 12))
					{
						
						if(p.hasPermission(bag_open_enchant))
						{
					        Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), 10000,255,10000));
					        if(!(b.getType() == Material.ENCHANTMENT_TABLE))
					        b.setType(Material.ENCHANTMENT_TABLE);
					        p.openEnchanting(b.getLocation(), true);
						}
					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 13))
					{
						if(p.hasPermission(bag_open_crafting))
						{
						p.openWorkbench(null, true);
						}
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 14))
					{
						if(p.hasPermission(bag_open_ender))
						{
						p.openInventory(p.getEnderChest());
						}
					}
				}
			
			
			
		
		
		
		
		
		
		
		
		
	}
	
	@EventHandler
	public void onInventoryMove(InventoryClickEvent e)
	{
		if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY)
		{
			if(e.getInventory().getName().equals("Bag"))
			{
				if(e.getCurrentItem().getType() != Material.AIR)
				{
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)10))
				e.setCancelled(true);
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)11))
				e.setCancelled(true);
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)12))
				e.setCancelled(true);
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)13))
				e.setCancelled(true);
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)14))
				e.setCancelled(true);
				}
			}
			
		}
		
	}

}
