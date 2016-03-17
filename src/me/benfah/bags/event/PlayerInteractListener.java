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
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.benfah.bags.main.Bags;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.Util;

public class PlayerInteractListener implements Listener{

	
	
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

							String ints = h.getItemMeta().getLore().iterator().next();
							int id = Integer.parseInt(ints);
							Inventory inv = BagManager.bag.get(id) != null ? (Inventory) BagManager.bag.get(id)[0] : Bukkit.createInventory(p, 27, "Bag");
							
							p.openInventory(inv);
							BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							
							
							
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

							String ints = h.getItemMeta().getLore().iterator().next();
							int id = Integer.parseInt(ints);
							Inventory inv = BagManager.bag.get(id) != null ? (Inventory) BagManager.bag.get(id)[0] : Bukkit.createInventory(p, 54, "Bag");
							
							p.openInventory(inv);
							BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							
							
							
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
						
							
				         Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), 10000,255,10000));
				         if(!(b.getType() == Material.ENCHANTMENT_TABLE))
				         b.setType(Material.ENCHANTMENT_TABLE);
				         p.openEnchanting(b.getLocation(), true);

					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 13))
					{
						
						p.openWorkbench(null, true);
						
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 14))
					{
						
						p.openInventory(p.getEnderChest());
						
					}
				}
			
			
			
		
		
		
		
		
		
		
		
		
	}
	
	
}
