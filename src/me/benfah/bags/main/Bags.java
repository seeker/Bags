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

import me.benfah.bags.command.CommandBags;
import me.benfah.bags.event.CraftListener;
import me.benfah.bags.event.PlayerInteractListener;
import me.benfah.bags.event.PlayerJoinListener;
import me.benfah.bags.translation.Translation;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.SaveRunnable;

public class Bags extends JavaPlugin{

	public static FileConfiguration cfg;
	public static File cfgFile;
	public static BagManager bm;
	public static String not_allowed;
	
	
	
	public static void playOpenSound(Player p){p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF,  0.5f, 1f);}
	@Override
	public void onEnable() {
		
		getCommand("bags").setExecutor(new CommandBags());
 		cfgFile = new File(getDataFolder(), "cfg.yml");
 		
 		
		not_allowed = ChatColor.RED + "You are not allowed to do this!";
		cfg = YamlConfiguration.loadConfiguration(cfgFile);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new CraftListener(), this);
		bm = new BagManager(this);
		
		if(!cfg.contains("langfile"))
		{
			cfg.set("langfile", "en.yml");
		}
		
		if(!cfg.contains("custom-resourcepack"))
		cfg.set("custom-resourcepack", false);
		
		if(!cfg.contains("custom-resourcepack-link"))
		cfg.set("custom-resourcepack-link", "Replace_me_with_the_link");
		
		try {
			cfg.save(cfgFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Translation.registerFiles();
		Translation.updateTranslation();
		Translation.readTranslation();
		
		
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
	public void onDisable() {
		
		bm.shutdown();
		
	}
	
	
	
	
}
