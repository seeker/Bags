package me.benfah.bags.translation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.benfah.bags.main.Bags;

public class Translation
{
	public static File transFile;
	public static String not_allowed;
	public static String bag;
	public static String bag_big;
	public static String bag_enc;
	public static String bag_craft;
	public static String bag_ender;
	public static String bag_anvil;
	public static String bag_inventory;
	public static String bag_credits1;
	public static String bag_credits2;
	public static String bag_credits3;

	public static String bag_cmdhelp1;
	public static String bag_cmdhelp2;
	public static String bag_cmdhelp3;

	public static String bag_give_syntax;
	public static FileConfiguration transCfg;
	
	public static void registerFiles()
	{
		
		File langDir = new File("plugins/Bags/lang");
		if(!langDir.exists())
		{
		langDir.mkdirs();
		}
		String s = Bags.cfg.getString("langfile");
		transFile = new File("plugins/Bags/lang", s);
		try {
			if(!transFile.exists())
			{
			transFile.createNewFile();
			
			transCfg = YamlConfiguration.loadConfiguration(transFile);
			}
			else
			transCfg = YamlConfiguration.loadConfiguration(transFile);
			
			putStandardTranslation();
			
		} catch (IOException e1) {
			System.err.println("Can't create the en.yml lang file!");
			
		}
		
	}

	public static void putStandardTranslation()
	{
		
		transCfg.set("not_allowed", "&4You are not allowed to do this!");
		transCfg.set("bag", "Bag");
		transCfg.set("bag_big", "Bag");
		transCfg.set("bag_enc", "Enchantment Bag");
		transCfg.set("bag_craft", "Crafting Bag");
		transCfg.set("bag_ender", "Ender Bag");
		transCfg.set("bag_anvil", "Anvil Bag");
		transCfg.set("bag_inventory", "Bag");
		transCfg.set("bag_credits1", "&6benfah | For coding this plugin :3");
		transCfg.set("bag_credits2", "&6Halbzwilling | For discovering the texture trick :3");
		transCfg.set("bag_credits3", "&6Eydamos | For the inspiration :3");
		transCfg.set("bag_give_syntax", "&4Syntax: /bags give <normal:big:craft:enchant:ender:anvil>");
		transCfg.set("bag_cmdhelp1", "&6/bags credits | Shows the credits of the plugin :3");
		transCfg.set("bag_cmdhelp2", "&6/bags resource | Sends a resourcepack request");
		transCfg.set("bag_cmdhelp3", "&6/bags give <Bag> | Gives you the bag you specified");


		try {
			transCfg.save(transFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void readTranslation()
	{
		
		
		not_allowed = transCfg.getString("not_allowed").replace("&", "§");
		bag = transCfg.getString("bag").replace("&", "§");
		bag_big = transCfg.getString("bag_big").replace("&", "§");
		bag_enc = transCfg.getString("bag_enc").replace("&", "§");
		bag_craft = transCfg.getString("bag_craft").replace("&", "§");
		bag_ender = transCfg.getString("bag_ender").replace("&", "§");
		bag_anvil = transCfg.getString("bag_anvil").replace("&", "§");
		bag_inventory = transCfg.getString("bag_inventory").replace("&", "§");
		bag_credits1 = transCfg.getString("bag_credits1").replace("&", "§");
		bag_credits2 = transCfg.getString("bag_credits2").replace("&", "§");
		bag_credits3 = transCfg.getString("bag_credits3").replace("&", "§");
		bag_give_syntax = transCfg.getString("bag_give_syntax").replace("&", "§");
		bag_cmdhelp1 = transCfg.getString("bag_cmdhelp1").replace("&", "§");
		bag_cmdhelp2 = transCfg.getString("bag_cmdhelp2").replace("&", "§");
		bag_cmdhelp3 = transCfg.getString("bag_cmdhelp3").replace("&", "§");


	}
	
}
