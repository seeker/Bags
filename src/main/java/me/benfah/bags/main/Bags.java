package me.benfah.bags.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.benfah.bags.command.CommandBags;
import me.benfah.bags.event.CraftListener;
import me.benfah.bags.event.PlayerInteractListener;
import me.benfah.bags.event.PlayerJoinListener;
import me.benfah.bags.translation.Translation;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.SaveRunnable;

public class Bags extends JavaPlugin{

	public static Inventory langInv;
	
	
	public static FileConfiguration cfg;
	public static File cfgFile;
	
	public static Bags inst;
	
	public static FileConfiguration countCfg;
	public static File countCfgFile;
	public static BagManager bm;
	public static String not_allowed;
	
	public static FileConfiguration recipeCfg;
	public static File recipeCfgFile;
	
	public static boolean rlActive = false;
	
	public static void playOpenSound(Player p){p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF,  0.5f, 1f);}
	
	
	
	@Override
	public void onEnable()
	{
		
		
		
		inst = this;
		initInv();
		
		recipeCfgFile = new File(getDataFolder(), "recipes.yml");
		
		getCommand("bags").setExecutor(new CommandBags());
 		cfgFile = new File(getDataFolder(), "cfg.yml");
 		
 		countCfgFile = new File(getDataFolder(), "count.yml");
 		
 		if(!recipeCfgFile.exists())
 		{
 			try {
				recipeCfgFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
 		}
 			
 			
 		if(!countCfgFile.exists())
			try {
				countCfgFile.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
 		countCfg = YamlConfiguration.loadConfiguration(countCfgFile);
 		recipeCfg = YamlConfiguration.loadConfiguration(recipeCfgFile);
		not_allowed = ChatColor.RED + "You are not allowed to do this!";
		cfg = YamlConfiguration.loadConfiguration(cfgFile);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new CraftListener(), this);
		bm = new BagManager(this);
		
		
		
			
		
		if(!cfg.contains("resourcepack-enabled"))
		cfg.set("resourcepack-enabled", true);
		if(!cfg.contains("langfile"))
		{
			cfg.set("langfile", "en.yml");
		}
		
		if(!cfg.contains("bag_size"))
		cfg.set("bag_size", 27);
		
		if(!cfg.contains("bag_big_size"))
		cfg.set("bag_big_size", 54);
		
		if(cfg.contains("bagid"))
		{
			countCfg.set("bagid", cfg.getInt("bagid"));
			cfg.set("bagid", null);
			try {
				cfg.save(cfgFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!cfg.contains("custom-resourcepack"))
		cfg.set("custom-resourcepack", false);
		
		if(!cfg.contains("custom-resourcepack-link"))
		cfg.set("custom-resourcepack-link", "Replace_me_with_the_link");
		
		if(!cfg.contains("bags-in-bags"))
		cfg.set("bags-in-bags", false);
				
		
		try {
			cfg.save(cfgFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Translation.registerFiles();
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
		
		try {
			countCfg.save(countCfgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("serial")
	public static void initInv()
	{
		ItemStack stackDE = new ItemStack(Material.WOOL, 1, (short) 14);
		ItemStack stackEN = new ItemStack(Material.WOOL, 1);
		ItemStack stackSV = new ItemStack(Material.WOOL, 1, (short) 11);
		ItemStack stackES = new ItemStack(Material.WOOL, 1, (short) 4);
		
		ItemMeta imDE = stackDE.getItemMeta();
		ItemMeta imEN = stackEN.getItemMeta();
		ItemMeta imSV = stackSV.getItemMeta();
		ItemMeta imES = stackES.getItemMeta();
		
		imDE.setDisplayName(ChatColor.YELLOW + "German (Deutsch)");
		imEN.setDisplayName(ChatColor.YELLOW + "English");
		imSV.setDisplayName(ChatColor.YELLOW + "Swedish (Svensk)");
		imES.setDisplayName(ChatColor.YELLOW + "Spanish (Español)");
		imDE.setLore(new ArrayList<String>(){{
			add("");
			add(ChatColor.GREEN + "> Translation by: benfah");
		}});
		imEN.setLore(new ArrayList<String>(){{
			add("");
			add(ChatColor.GREEN + "> Translation by: benfah");
		}});
		imSV.setLore(new ArrayList<String>(){{
			add("");
			add(ChatColor.GREEN + "> Translation by: sketaful");
		}});
		
		imES.setLore(new ArrayList<String>(){{
			add("");
			add(ChatColor.GREEN + "> Translation by: WasdCat");
		}});
		
		stackDE.setItemMeta(imDE);
		stackEN.setItemMeta(imEN);
		stackSV.setItemMeta(imSV);
		stackES.setItemMeta(imES);
		
		langInv = Bukkit.createInventory(null,9, "Languages");
		langInv.addItem(stackEN);
		langInv.addItem(stackSV);
		langInv.addItem(stackES);
		langInv.addItem(stackDE);

	}
	
	
}
