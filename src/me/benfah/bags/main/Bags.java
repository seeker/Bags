package me.benfah.bags.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.benfah.bags.event.PlayerInteractListener;
import me.benfah.bags.event.PlayerJoinListener;
import me.benfah.bags.util.Attributes;
import me.benfah.bags.util.Attributes.Attribute;
import me.benfah.bags.util.Attributes.AttributeType;
import me.benfah.bags.util.BagManager;
import me.benfah.bags.util.SaveRunnable;

public class Bags extends JavaPlugin{

	public static FileConfiguration cfg;
	public static File cfgFile;
	public static BagManager bm;
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
		
		ItemStack bag = new ItemStack(Material.STONE_SWORD);
		ItemMeta im = bag.getItemMeta();
		im.setDisplayName(ChatColor.RESET + "Bag");
		im.spigot().setUnbreakable(true);
		bag.setItemMeta(im);
		bag.setDurability((short) 10);
		Attributes ab = new Attributes(bag);
		ab.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		ab.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack newStack = ab.getStack();
		
		ShapedRecipe sr = new ShapedRecipe(Attributes.hideFlags(newStack, 38));
		sr.shape("ILI", "LSL", "LLL");
		sr.setIngredient('S', Material.STRING);
		sr.setIngredient('L', Material.LEATHER);
		sr.setIngredient('I', Material.IRON_INGOT);

		Bukkit.addRecipe(sr);
		
		ItemStack bagbig = new ItemStack(Material.STONE_SWORD);
		ItemMeta imb = bagbig.getItemMeta();
		imb.setDisplayName(ChatColor.RESET + "Big Bag");
		imb.spigot().setUnbreakable(true);
		bagbig.setItemMeta(imb);
		bagbig.setDurability((short) 11);
		Attributes abb = new Attributes(bagbig);
		abb.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		abb.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack newStackB = abb.getStack();
		
		ShapedRecipe srB = new ShapedRecipe(Attributes.hideFlags(newStackB, 38));
		srB.shape("GLG", "LSL", "LLL");
		srB.setIngredient('S', Material.STRING);
		srB.setIngredient('L', Material.LEATHER);
		srB.setIngredient('G', Material.GOLD_INGOT);

		Bukkit.addRecipe(srB);
		
		ItemStack bagenc = new ItemStack(Material.STONE_SWORD);
		ItemMeta ime = bagenc.getItemMeta();
		ime.setDisplayName(ChatColor.RESET + "Enchantment Bag");
		ime.spigot().setUnbreakable(true);
		bagenc.setItemMeta(ime);
		bagenc.setDurability((short) 12);
		Attributes abe = new Attributes(bagenc);
		abe.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		abe.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack newStackE = abe.getStack();
		
		ShapedRecipe srE = new ShapedRecipe(Attributes.hideFlags(newStackE, 38));
		srE.shape("GLG", "LSL", "LEL");
		srE.setIngredient('S', Material.STRING);
		srE.setIngredient('L', Material.LEATHER);
		srE.setIngredient('G', Material.GOLD_INGOT);
		srE.setIngredient('E', Material.ENCHANTMENT_TABLE);

		
		Bukkit.addRecipe(srE);
		
		ItemStack bagcra = new ItemStack(Material.STONE_SWORD);
		ItemMeta imc = bagcra.getItemMeta();
		imc.setDisplayName(ChatColor.RESET + "Crafting Bag");
		imc.spigot().setUnbreakable(true);
		bagcra.setItemMeta(imc);
		bagcra.setDurability((short) 13);
		Attributes abc = new Attributes(bagcra);
		abc.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		abc.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack newStackC = abc.getStack();
		
		ShapedRecipe srC = new ShapedRecipe(Attributes.hideFlags(newStackC, 38));
		srC.shape("ILI", "LSL", "LCL");
		srC.setIngredient('S', Material.STRING);
		srC.setIngredient('L', Material.LEATHER);
		srC.setIngredient('C', Material.WORKBENCH);
		srC.setIngredient('I', Material.IRON_INGOT);

		
		Bukkit.addRecipe(srC);
		
		
		ItemStack bagend = new ItemStack(Material.STONE_SWORD);
		ItemMeta imen = bagend.getItemMeta();
		imen.setDisplayName(ChatColor.RESET + "Ender Bag");
		imen.spigot().setUnbreakable(true);
		bagend.setItemMeta(imen);
		bagend.setDurability((short) 14);
		Attributes aben = new Attributes(bagend);
		aben.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		aben.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack newStackEN = aben.getStack();
		
		
		ShapedRecipe srEN = new ShapedRecipe(Attributes.hideFlags(newStackEN, 38));
		srEN.shape("GDG", "LSL", "LEL");
		srEN.setIngredient('S', Material.STRING);
		srEN.setIngredient('L', Material.LEATHER);
		srEN.setIngredient('G', Material.GOLD_INGOT);
		srEN.setIngredient('D', Material.DIAMOND);
		srEN.setIngredient('E', Material.ENDER_CHEST);

		
		Bukkit.addRecipe(srEN);
		
		super.onEnable();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("bags"))
		{
			if(args.length == 1)
			{
				if(args[0].equalsIgnoreCase("credits"))
				{
					
					sender.sendMessage(ChatColor.GOLD + "benfah | For coding this plugin :3");
					sender.sendMessage(ChatColor.GOLD + "Halbzwilling | For discovering that texture trick which doesn't affects the game :3");
					sender.sendMessage(ChatColor.GOLD + "Eydamos | For the inspiration and the textures :3");

				}
				if(args[0].equalsIgnoreCase("resource"))
				{
					if(sender.hasPermission("bags.resource"))
					{
						if(sender instanceof Player)
						{
							((Player)sender).setResourcePack("https://www.dropbox.com/s/dc2bpx4w0loavuo/Bags.zip?dl=1");
							
						}
						else
						System.out.println("You are not a player!");
					}
					

				}
				
				
				
				sender.sendMessage(ChatColor.GOLD + "/bags credits | Shows the credits of the plugin :3");
				sender.sendMessage(ChatColor.GOLD + "/bags resource | Sends a resourcepack request");
				
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
