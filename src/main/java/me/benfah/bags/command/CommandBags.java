package me.benfah.bags.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.main.RecipeManager;
import me.benfah.bags.translation.Translation;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.Util;

public class CommandBags implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("bags"))
		{
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("edit"))
				{
					if(args.length == 2)
					{
							if(sender.hasPermission(new Permission("bag.edit", PermissionDefault.OP)))
							{
								
								int i;
								if(!Util.isInteger(args[1]))
								return false;
								if(sender instanceof Player)
								{
									i = Integer.parseInt(args[1]);
									Player p = (Player)sender;
									if(BagManager.bag.get(i) != null)
									p.openInventory((Inventory) BagManager.bag.get(i)[0]);
								}
							}
						
					}
				}
				if(args[0].equalsIgnoreCase("list"))
				{ 
				if(sender.hasPermission(new Permission("bag.list", PermissionDefault.OP)))
				{
					if(args.length >= 2)
					{
						if(Util.isInteger(args[1]))
						{
							int value = Integer.parseInt(args[1]);
							
							sender.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------------------------");
							
							
							

							
							for(int i = value * 25 - 24; i < value * 25 + 1; i++)
							{
								Object[] obj = BagManager.bag.get(i);

								if(obj != null)
								{
								if(obj.length >= 4)
								sender.sendMessage(ChatColor.DARK_AQUA + "BagID: §2" + i + "§3 | Last Used By: §2" + obj[2] + "§3 | Owner: §2" + obj[3]);
								else
								sender.sendMessage(ChatColor.DARK_AQUA + "BagID: §2" + i + "§3 | Last Used By: §2Unknown " + "§3| Owner: " + "§2Unknown");		
								}

							}
							sender.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------------------------");
							sender.sendMessage("");

						}
					}
					else
					{
						sender.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------------------------");
						for(int i = 1; i < 25 + 1; i++)
						{
							Object[] obj = BagManager.bag.get(i);
							if(obj != null)
							{
							if(obj.length >= 4)
							sender.sendMessage(ChatColor.DARK_AQUA + "BagID: §2" + i + "§3 | Last Used By: §2" + obj[2] + "§3 | Owner: §2" + obj[3]);
							else
							sender.sendMessage(ChatColor.DARK_AQUA + "BagID: §2" + i + "§3 | Last Used By: §2Unknown " + "§3| Owner: " + "§2Unknown");
							}

						}
						sender.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------------------------");
						sender.sendMessage("");
					}
				}
				else
				sender.sendMessage(Translation.not_allowed);
				}
				if(args[0].equalsIgnoreCase("lang"))
				{
					if(sender.hasPermission(new Permission("bag.lang", PermissionDefault.OP)))
					{
						((Player)sender).openInventory(Bags.langInv);
					}
				}
				if(args[0].equalsIgnoreCase("credits"))
				{
					
					sender.sendMessage(Translation.bag_credits1);
					sender.sendMessage(Translation.bag_credits2);
					sender.sendMessage(Translation.bag_credits3);

				}
				if(args[0].equalsIgnoreCase("resource"))
				{
					if(sender.hasPermission(new Permission("bag.resource", PermissionDefault.TRUE)))
					{
						if(sender instanceof Player)
						{
							Util.sendRequest((Player)sender);
						}
						else
						System.out.println(Translation.not_allowed);
					}
					
					

				}
				if(args[0].equalsIgnoreCase("give"))
				{
					if(sender.hasPermission(new Permission("bag.give", PermissionDefault.OP)))
					{
						if(args.length == 2)
						{
								if(args[1].equalsIgnoreCase("normal"))
									((Player)sender).getInventory().addItem(RecipeManager.getBag());
								if(args[1].equalsIgnoreCase("big"))
									((Player)sender).getInventory().addItem(RecipeManager.getBigBag());
								if(args[1].equalsIgnoreCase("craft"))
									((Player)sender).getInventory().addItem(RecipeManager.getCraftingBag());
								if(args[1].equalsIgnoreCase("ender"))
									((Player)sender).getInventory().addItem(RecipeManager.getEnderBag());
								if(args[1].equalsIgnoreCase("enchant"))
									((Player)sender).getInventory().addItem(RecipeManager.getEnchantmentBag());
								if(args[1].equalsIgnoreCase("anvil"))
									((Player)sender).getInventory().addItem(RecipeManager.getAnvilBag());
								
							
							
							
							
							
						}
						else
						if(args.length == 3)
						{
							Player target = Bukkit.getPlayer(args[2]);
							if(target != null)
							{
							if(args[1].equalsIgnoreCase("normal"))
								target.getInventory().addItem(RecipeManager.getBag());
							if(args[1].equalsIgnoreCase("big"))
								target.getInventory().addItem(RecipeManager.getBigBag());
							if(args[1].equalsIgnoreCase("craft"))
								target.getInventory().addItem(RecipeManager.getCraftingBag());
							if(args[1].equalsIgnoreCase("ender"))
								target.getInventory().addItem(RecipeManager.getEnderBag());
							if(args[1].equalsIgnoreCase("enchant"))
								target.getInventory().addItem(RecipeManager.getEnchantmentBag());
							if(args[1].equalsIgnoreCase("anvil"))
								target.getInventory().addItem(RecipeManager.getAnvilBag());
							}
							else
							{
								sender.sendMessage(Translation.p_not_found);
							}
						}
						else
						sender.sendMessage(Translation.bag_give_syntax);
					}
					else
					sender.sendMessage(Translation.not_allowed);
				}
				
				
				
				
			}
			else
			{
				sender.sendMessage(Translation.bag_cmdhelp1);
				sender.sendMessage(Translation.bag_cmdhelp2);
				sender.sendMessage(Translation.bag_cmdhelp3);
				sender.sendMessage(Translation.bag_cmdhelp4);
				sender.sendMessage(ChatColor.GOLD + "/bags lang");
			}
			
		}
		return false;
	}
}
