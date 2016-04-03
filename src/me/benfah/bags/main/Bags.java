package me.benfah.bags.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

import me.benfah.bags.event.PlayerInteractListener;
import me.benfah.bags.event.PlayerJoinListener;
import me.benfah.bags.util.AnvilInterface;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.SaveRunnable;

public class Bags extends JavaPlugin{

	public static FileConfiguration cfg;
	public static File cfgFile;
	public static BagManager bm;
	public static AnvilInterface anv;
	
	public static void playOpenSound(Player p){p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF,  0.5f, 1f);}
	@Override
	public void onEnable() {
		
		
		cfgFile = new File(getDataFolder(), "cfg.yml");
		
		cfg = YamlConfiguration.loadConfiguration(cfgFile);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		cfg.addDefault("resourcepack", true);
		bm = new BagManager(this);
		Bukkit.getScheduler().runTaskTimerAsynchronously(this, new SaveRunnable(), 2400L, 2400L);
		File f = new File(getDataFolder(), "saveb64.dat");
		try {
			if(!f.exists())
			{
				this.getDataFolder().mkdirs();
				f.createNewFile();
			}
			else
			bm.init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RecipeManager rm  = new RecipeManager();
		super.onEnable();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
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
							((Player)sender).setResourcePack("https://www.dropbox.com/s/dc2bpx4w0loavuo/Bags.zip?dl=1");
							
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
							switch(args[1].toLowerCase())
							{
								case "normal":
									((Player)sender).getInventory().addItem(RecipeManager.getBag());
								case "big":
									((Player)sender).getInventory().addItem(RecipeManager.getBigBag());
								case "craft":
									((Player)sender).getInventory().addItem(RecipeManager.getCraftingBag());
								case "enchant":
									((Player)sender).getInventory().addItem(RecipeManager.getEnchantmentBag());
								case "ender":
									((Player)sender).getInventory().addItem(RecipeManager.getEnderBag());
								case "anvil":
									((Player)sender).getInventory().addItem(RecipeManager.getAnvilBag());
								
							}
							
							
							
							
						}
						else
						sender.sendMessage(ChatColor.RED + "Syntax: /bags give <normal:big:craft:enchant:ender:anvil>");
					}
					else
					sender.sendMessage(ChatColor.RED + "You are not allowed to do this!");
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
	@Override
	public void onDisable() {
		
		bm.shutdown();
		try {
			cfg.save(cfgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
