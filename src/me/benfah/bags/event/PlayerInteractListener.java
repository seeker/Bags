package me.benfah.bags.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.translation.Translation;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.Util;
import me.benfah.bags.util.v1_9_R1.Anvil;

public class PlayerInteractListener implements Listener{
	final Permission bag_open_small = new Permission("bag.open.small", PermissionDefault.TRUE);
	final Permission bag_open_big = new Permission("bag.open.big", PermissionDefault.TRUE);
	final Permission bag_open_enchant = new Permission("bag.open.enchant", PermissionDefault.TRUE);
	final Permission bag_open_crafting = new Permission("bag.open.crafting", PermissionDefault.TRUE);
	final Permission bag_open_ender = new Permission("bag.open.ender", PermissionDefault.TRUE);
	final Permission bag_open_anvil = new Permission("bag.open.anvil", PermissionDefault.TRUE);

	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		if(e.getAction() != Action.PHYSICAL)
		{
			Player p = e.getPlayer();
			ItemStack h = p.getInventory().getItemInMainHand();
				if((h.getType() == Material.STONE_SWORD))
				{
					if(Util.isUnbreakableAndHasDamage(h, (short) 10))
					{

						if(h.getItemMeta().hasLore())
						{
							if(p.hasPermission(bag_open_small))
							{
								Bags.playOpenSound(p);
								
								ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
								
								
								String ints = h.getItemMeta().getLore().iterator().next();
								int id = Integer.parseInt(ints);
								Inventory inv = BagManager.bag.get(id) != null ? ((Inventory) BagManager.bag.get(id)[0]) : Bukkit.createInventory(p, 27, Translation.bag_inventory);

								if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
								if(!stack.getItemMeta().getDisplayName().equals(Translation.bag))
								{
									
									ItemMeta im = stack.getItemMeta();
									im.setDisplayName(ChatColor.RESET + Translation.bag);
									stack.setItemMeta(im);
								}
								p.openInventory(inv);
								BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							}
							else
					        	   p.sendMessage(Bags.not_allowed);

							
						}
						else
						{
							ItemMeta hm = h.getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add("" + (Bags.countCfg.getInt("bagid") + 1));
							Bags.countCfg.set("bagid",	Bags.countCfg.getInt("bagid") + 1);
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
								Bags.playOpenSound(p);

								String ints = h.getItemMeta().getLore().iterator().next();
								int id = Integer.parseInt(ints);
								Inventory inv = BagManager.bag.get(id) != null ? (Inventory) BagManager.bag.get(id)[0] : Bukkit.createInventory(p, 54, Translation.bag_inventory);
								ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
								if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
								if(!stack.getItemMeta().getDisplayName().equals(Translation.bag_big))
								{
									ItemMeta im = stack.getItemMeta();
									im.setDisplayName(ChatColor.RESET + Translation.bag_big);
									stack.setItemMeta(im);
								}
								p.openInventory(inv);
								BagManager.bag.put(id, new Object[]{inv, inv.getSize()});
							}
							else
					        	p.sendMessage(Bags.not_allowed);
							
						}
						else
						{

							ItemMeta hm = h.getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add("" + (Bags.countCfg.getInt("bagid") + 1));
							Bags.countCfg.set("bagid",	Bags.countCfg.getInt("bagid") + 1);
							hm.setLore(lore);
							h.setItemMeta(hm);
						}
							
							
							
							
							
					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 12))
					{
						
						if(p.hasPermission(bag_open_enchant))
						{
							Bags.playOpenSound(p);
							ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
							if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
							if(!stack.getItemMeta().getDisplayName().equals(Translation.bag_enc))
							{
								ItemMeta im = stack.getItemMeta();
								im.setDisplayName(ChatColor.RESET + Translation.bag_enc);
								stack.setItemMeta(im);
							}
					        Block b = p.getWorld().getBlockAt(new Location(p.getWorld(), 10000,255,10000));
					        if(!(b.getType() == Material.ENCHANTMENT_TABLE))
					        b.setType(Material.ENCHANTMENT_TABLE);
					        p.openEnchanting(b.getLocation(), true);
						}
						else
				        	   p.sendMessage(Bags.not_allowed);

					
					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 13))
					{
						if(p.hasPermission(bag_open_crafting))
						{
							
							Bags.playOpenSound(p);
							ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
							if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
							if(!stack.getItemMeta().getDisplayName().equals(Translation.bag_craft))
							{
								ItemMeta im = stack.getItemMeta();
								im.setDisplayName(ChatColor.RESET + Translation.bag_craft);
								stack.setItemMeta(im);
							}
							p.openWorkbench(null, true);
						}
						else
			        	   p.sendMessage(Bags.not_allowed);

					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 14))
					{
						if(p.hasPermission(bag_open_ender))
						{
							
							Bags.playOpenSound(p);
							ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
							if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
							if(!stack.getItemMeta().getDisplayName().equals(Translation.bag_ender))
							{
								ItemMeta im = stack.getItemMeta();
								im.setDisplayName(ChatColor.RESET + Translation.bag_ender);
								stack.setItemMeta(im);
							}
						p.openInventory(p.getEnderChest());
						}
						else
				        	   p.sendMessage(Bags.not_allowed);

					}
					if(Util.isUnbreakableAndHasDamage(h, (short) 15))
					{
						//String version;
			            //version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
			            
			           if(p.hasPermission(bag_open_anvil))
			           {
							Bags.playOpenSound(p);
							ItemStack stack = e.getPlayer().getInventory().getItemInMainHand();
							if(stack.getItemMeta().getDisplayName().startsWith(ChatColor.RESET + ""))
							if(!stack.getItemMeta().getDisplayName().equals(Translation.bag_anvil))
							{
								ItemMeta im = stack.getItemMeta();
								im.setDisplayName(ChatColor.RESET + Translation.bag_anvil);
								stack.setItemMeta(im);
							}
			            	Anvil a = new Anvil(((CraftPlayer)p).getHandle());
			            	a.openAnvil(p);
			           }
			           else
			        	   p.sendMessage(Bags.not_allowed);
			           
					}
				}
		}
			
			
			
		
		
		
		
		
		
		
		
		
	}
	
	@EventHandler
	public void onInventoryMove(InventoryClickEvent e)
	{
		if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY || e.getAction() == InventoryAction.PICKUP_ALL || e.getAction() == InventoryAction.PICKUP_HALF)
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
				if(Util.isUnbreakableAndHasDamage(e.getCurrentItem(), (short)15))
				e.setCancelled(true);
				}
			}
			
		}
		
	}
	public static void save()
	{
		try {
			Bags.cfg.save(Bags.cfgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
