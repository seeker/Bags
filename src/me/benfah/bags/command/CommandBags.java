package me.benfah.bags.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;
import me.benfah.bags.main.RecipeManager;

public class CommandBags implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("hi");

		if(command.getName().equalsIgnoreCase("bags"))
		{
			if(args.length >= 1)
			{
				if(args[0].equalsIgnoreCase("credits"))
				{
					
					sender.sendMessage(ChatColor.GOLD + "benfah | For coding this plugin :3");
					sender.sendMessage(ChatColor.GOLD + "Halbzwilling | For discovering that texture trick which doesn't affects the game :3");
					sender.sendMessage(ChatColor.GOLD + "Eydamos | For the inspiration and the textures :3");

				}
				if(args[0].equalsIgnoreCase("resource"))
				{
					if(sender.hasPermission(new Permission("bag.resource", PermissionDefault.TRUE)))
					{
						if(sender instanceof Player)
						{
							((Player)sender).setResourcePack("https://www.dropbox.com/s/dc2bpx4w0loavuo/Bags2.zip?dl=1");
							
						}
						else
						System.out.println("You are not a player!");
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
						sender.sendMessage(ChatColor.RED + "Syntax: /bags give <normal:big:craft:enchant:ender:anvil>");
					}
					else
					sender.sendMessage(Bags.not_allowed);
				}
				
				
				
				
			}
			else
			{
				sender.sendMessage(ChatColor.GOLD + "/bags credits | Shows the credits of the plugin :3");
				sender.sendMessage(ChatColor.GOLD + "/bags resource | Sends a resourcepack request");
				sender.sendMessage(ChatColor.GOLD + "/bags give <Bag> | Gives you the bag you specified");
			}
			
		}
		return false;
	}
}
