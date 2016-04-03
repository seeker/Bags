package me.benfah.bags.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.benfah.bags.util.Attributes;
import me.benfah.bags.util.Attributes.Attribute;
import me.benfah.bags.util.Attributes.AttributeType;

public class RecipeManager {

	
	public RecipeManager()
	{
		doRecipes();
	}
	
	public void doRecipes()
	{
		//Standard Bag
		ShapedRecipe sr = new ShapedRecipe(getBag());
		sr.shape("ILI", "LSL", "LLL");
		sr.setIngredient('S', Material.STRING);
		sr.setIngredient('L', Material.LEATHER);
		sr.setIngredient('I', Material.IRON_INGOT);

		Bukkit.addRecipe(sr);
		
		//Big Bag
		ShapedRecipe srB = new ShapedRecipe(getBigBag());
		srB.shape("GLG", "LSL", "LLL");
		srB.setIngredient('S', Material.STRING);
		srB.setIngredient('L', Material.LEATHER);
		srB.setIngredient('G', Material.GOLD_INGOT);

		Bukkit.addRecipe(srB);
		
		//Enchantment Bag
		ShapedRecipe srE = new ShapedRecipe(getEnchantmentBag());
		srE.shape("GLG", "LSL", "LEL");
		srE.setIngredient('S', Material.STRING);
		srE.setIngredient('L', Material.LEATHER);
		srE.setIngredient('G', Material.GOLD_INGOT);
		srE.setIngredient('E', Material.ENCHANTMENT_TABLE);

		
		Bukkit.addRecipe(srE);
		
		//Crafting Bag
		ShapedRecipe srC = new ShapedRecipe(getCraftingBag());
		srC.shape("ILI", "LSL", "LCL");
		srC.setIngredient('S', Material.STRING);
		srC.setIngredient('L', Material.LEATHER);
		srC.setIngredient('C', Material.WORKBENCH);
		srC.setIngredient('I', Material.IRON_INGOT);

		
		Bukkit.addRecipe(srC);
		
		//Ender Bag
		ShapedRecipe srEN = new ShapedRecipe(getEnderBag());
		srEN.shape("GDG", "LSL", "LEL");
		srEN.setIngredient('S', Material.STRING);
		srEN.setIngredient('L', Material.LEATHER);
		srEN.setIngredient('G', Material.GOLD_INGOT);
		srEN.setIngredient('D', Material.DIAMOND);
		srEN.setIngredient('E', Material.ENDER_CHEST);

		
		Bukkit.addRecipe(srEN);
		
		//Anvil Bag
		ShapedRecipe srAN = new ShapedRecipe(getAnvilBag());
		srAN.shape("ILI", "LSL", "LAL");
		srAN.setIngredient('I', Material.IRON_BLOCK);
		srAN.setIngredient('L', Material.LEATHER);
		srAN.setIngredient('S', Material.STRING);
		srAN.setIngredient('A', Material.ANVIL);
				Bukkit.addRecipe(srAN);
	}
	
	
	public static ItemStack getBag()
	{
		ItemStack bag = new ItemStack(Material.STONE_SWORD);
		ItemMeta im = bag.getItemMeta();
		im.setDisplayName(ChatColor.RESET + "Bag");
		im.spigot().setUnbreakable(true);
		bag.setItemMeta(im);
		bag.setDurability((short) 10);
		
		return doStandardModifiers(bag);
	}
	public static ItemStack getAnvilBag()
	{
		ItemStack anvilbag = new ItemStack(Material.STONE_SWORD);
		ItemMeta aim = anvilbag.getItemMeta();
		aim.setDisplayName(ChatColor.RESET + "Anvil Bag");
		aim.spigot().setUnbreakable(true);
		anvilbag.setItemMeta(aim);
		anvilbag.setDurability((short) 15);
		
		return doStandardModifiers(anvilbag);
	}
	public static ItemStack getBigBag()
	{
		ItemStack bagbig = new ItemStack(Material.STONE_SWORD);
		ItemMeta imb = bagbig.getItemMeta();
		imb.setDisplayName(ChatColor.RESET + "Big Bag");
		imb.spigot().setUnbreakable(true);
		bagbig.setItemMeta(imb);
		bagbig.setDurability((short) 11);
		
		return doStandardModifiers(bagbig);
	}
	public static ItemStack getEnchantmentBag()
	{
		ItemStack bagenc = new ItemStack(Material.STONE_SWORD);
		ItemMeta ime = bagenc.getItemMeta();
		ime.setDisplayName(ChatColor.RESET + "Enchantment Bag");
		ime.spigot().setUnbreakable(true);
		bagenc.setItemMeta(ime);
		bagenc.setDurability((short) 12);
		
		return doStandardModifiers(bagenc);
	}
	public static ItemStack getCraftingBag()
	{
		ItemStack bagcra = new ItemStack(Material.STONE_SWORD);
		ItemMeta imc = bagcra.getItemMeta();
		imc.setDisplayName(ChatColor.RESET + "Crafting Bag");
		imc.spigot().setUnbreakable(true);
		bagcra.setItemMeta(imc);
		bagcra.setDurability((short) 13);
		
		return doStandardModifiers(bagcra);
	}
	public static ItemStack getEnderBag()
	{
		ItemStack bagend = new ItemStack(Material.STONE_SWORD);
		ItemMeta imen = bagend.getItemMeta();
		imen.setDisplayName(ChatColor.RESET + "Ender Bag");
		imen.spigot().setUnbreakable(true);
		bagend.setItemMeta(imen);
		bagend.setDurability((short) 14);
		
		return doStandardModifiers(bagend);
	}
	
	public static ItemStack doStandardModifiers(ItemStack stack)
	{
		//doing the standard modifier stuff that this item don't make damage anymore
		Attributes ab = new Attributes(stack);
		ab.add(Attribute.newBuilder().name("AttackSpeed").type(AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		ab.add(Attribute.newBuilder().name("AttackDamage").type(AttributeType.GENERIC_ATTACK_DAMAGE).amount(0.5).build());
		ItemStack stack2 = ab.getStack();
		stack2 = Attributes.hideFlags(stack2, 38);
		return stack2;
	}
}
