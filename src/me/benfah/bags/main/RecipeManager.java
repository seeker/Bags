package me.benfah.bags.main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.benfah.bags.translation.Translation;

public class RecipeManager {

	
	public RecipeManager()
	{
		init();
		doRecipes();
	}
	
	public void init()
	{
		setRecipeInConfig("nor", Material.IRON_INGOT, Material.LEATHER, Material.IRON_INGOT, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.LEATHER, Material.LEATHER);
		setRecipeInConfig("big", Material.GOLD_INGOT, Material.LEATHER, Material.GOLD_INGOT, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.LEATHER, Material.LEATHER);
		setRecipeInConfig("cra", Material.IRON_INGOT, Material.LEATHER, Material.IRON_INGOT, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.WORKBENCH, Material.LEATHER);
		setRecipeInConfig("anv", Material.IRON_BLOCK, Material.LEATHER, Material.IRON_BLOCK, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.ANVIL, Material.LEATHER);
		setRecipeInConfig("enc", Material.GOLD_INGOT, Material.LEATHER, Material.GOLD_INGOT, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.ENCHANTMENT_TABLE, Material.LEATHER);
		setRecipeInConfig("end", Material.GOLD_INGOT, Material.DIAMOND, Material.GOLD_INGOT, Material.LEATHER, Material.STRING, Material.LEATHER, Material.LEATHER, Material.ENDER_CHEST, Material.LEATHER);

	}
	
	public void doRecipes()
	{
		//Standard Bag
		ShapedRecipe sr = new ShapedRecipe(getBag());
		
		
		
		sr.shape("ABC", "DEF", "GHI");
		sr.setIngredient('A', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.1")));
		sr.setIngredient('B', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.2")));
		sr.setIngredient('C', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.3")));
		sr.setIngredient('D', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.4")));
		sr.setIngredient('E', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.5")));
		sr.setIngredient('F', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.6")));
		sr.setIngredient('G', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.7")));
		sr.setIngredient('H', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.8")));
		sr.setIngredient('I', Material.valueOf(Bags.recipeCfg.getString("recipes.nor.9")));

		Bukkit.addRecipe(sr);
		
		//Big Bag
		ShapedRecipe srB = new ShapedRecipe(getBigBag());
		srB.shape("123", "456", "789");
		srB.setIngredient('1', Material.valueOf(Bags.recipeCfg.getString("recipes.big.1")));
		srB.setIngredient('2', Material.valueOf(Bags.recipeCfg.getString("recipes.big.2")));
		srB.setIngredient('3', Material.valueOf(Bags.recipeCfg.getString("recipes.big.3")));
		srB.setIngredient('4', Material.valueOf(Bags.recipeCfg.getString("recipes.big.4")));
		srB.setIngredient('5', Material.valueOf(Bags.recipeCfg.getString("recipes.big.5")));
		srB.setIngredient('6', Material.valueOf(Bags.recipeCfg.getString("recipes.big.6")));
		srB.setIngredient('7', Material.valueOf(Bags.recipeCfg.getString("recipes.big.7")));
		srB.setIngredient('8', Material.valueOf(Bags.recipeCfg.getString("recipes.big.8")));
		srB.setIngredient('9', Material.valueOf(Bags.recipeCfg.getString("recipes.big.9")));

		Bukkit.addRecipe(srB);
		
		//Enchantment Bag
		ShapedRecipe srE = new ShapedRecipe(getEnchantmentBag());
		srE.shape("123", "456", "789");
		srE.setIngredient('1', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.1")));
		srE.setIngredient('2', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.2")));
		srE.setIngredient('3', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.3")));
		srE.setIngredient('4', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.4")));
		srE.setIngredient('5', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.5")));
		srE.setIngredient('6', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.6")));
		srE.setIngredient('7', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.7")));
		srE.setIngredient('8', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.8")));
		srE.setIngredient('9', Material.valueOf(Bags.recipeCfg.getString("recipes.enc.9")));
		
		Bukkit.addRecipe(srE);
		
		//Crafting Bag
		ShapedRecipe srC = new ShapedRecipe(getCraftingBag());
		srC.shape("123", "456", "789");
		srC.setIngredient('1', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.1")));
		srC.setIngredient('2', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.2")));
		srC.setIngredient('3', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.3")));
		srC.setIngredient('4', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.4")));
		srC.setIngredient('5', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.5")));
		srC.setIngredient('6', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.6")));
		srC.setIngredient('7', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.7")));
		srC.setIngredient('8', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.8")));
		srC.setIngredient('9', Material.valueOf(Bags.recipeCfg.getString("recipes.cra.9")));

		
		Bukkit.addRecipe(srC);
		
		//Ender Bag
		ShapedRecipe srEN = new ShapedRecipe(getEnderBag());
		srEN.shape("123", "456", "789");
		srEN.setIngredient('1', Material.valueOf(Bags.recipeCfg.getString("recipes.end.1")));
		srEN.setIngredient('2', Material.valueOf(Bags.recipeCfg.getString("recipes.end.2")));
		srEN.setIngredient('3', Material.valueOf(Bags.recipeCfg.getString("recipes.end.3")));
		srEN.setIngredient('4', Material.valueOf(Bags.recipeCfg.getString("recipes.end.4")));
		srEN.setIngredient('5', Material.valueOf(Bags.recipeCfg.getString("recipes.end.5")));
		srEN.setIngredient('6', Material.valueOf(Bags.recipeCfg.getString("recipes.end.6")));
		srEN.setIngredient('7', Material.valueOf(Bags.recipeCfg.getString("recipes.end.7")));
		srEN.setIngredient('8', Material.valueOf(Bags.recipeCfg.getString("recipes.end.8")));
		srEN.setIngredient('9', Material.valueOf(Bags.recipeCfg.getString("recipes.end.9")));

		
		Bukkit.addRecipe(srEN);
		
		//Anvil Bag
		ShapedRecipe srAN = new ShapedRecipe(getAnvilBag());
		srAN.shape("123", "456", "789");
		srAN.setIngredient('1', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.1")));
		srAN.setIngredient('2', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.2")));
		srAN.setIngredient('3', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.3")));
		srAN.setIngredient('4', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.4")));
		srAN.setIngredient('5', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.5")));
		srAN.setIngredient('6', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.6")));
		srAN.setIngredient('7', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.7")));
		srAN.setIngredient('8', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.8")));
		srAN.setIngredient('9', Material.valueOf(Bags.recipeCfg.getString("recipes.anv.9")));
		
		
		Bukkit.addRecipe(srAN);
	}
	
	public static void setDamageAndUnbreakable(ItemStack stack, int damage, String displayName)
	{
		ItemMeta im = stack.getItemMeta();
		im.setDisplayName(ChatColor.RESET + displayName);
		im.spigot().setUnbreakable(true);
		stack.setItemMeta(im);
		stack.setDurability((short) damage);
	}
	public static ItemStack getBag()
	{
		ItemStack bag = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(bag, 10, Translation.bag);
		
		return doStandardModifiers(bag);
	}
	public static ItemStack getAnvilBag()
	{
		ItemStack anvilbag = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(anvilbag, 15, Translation.bag_anvil);

		
		return doStandardModifiers(anvilbag);
	}
	public static ItemStack getBigBag()
	{
		ItemStack bagbig = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(bagbig, 11, Translation.bag_big);

		
		return doStandardModifiers(bagbig);
	}
	public static ItemStack getEnchantmentBag()
	{
		ItemStack bagenc = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(bagenc, 12, Translation.bag_enc);

		
		return doStandardModifiers(bagenc);
	}
	public static ItemStack getCraftingBag()
	{
		ItemStack bagcra = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(bagcra, 13, Translation.bag_craft);
		
		return doStandardModifiers(bagcra);
	}
	public static ItemStack getEnderBag()
	{
		ItemStack bagend = new ItemStack(Material.STONE_SWORD);
		setDamageAndUnbreakable(bagend, 14, Translation.bag_ender);
		
		return doStandardModifiers(bagend);
	}
	
	public static ItemStack doStandardModifiers(ItemStack stack)
	{
		//doing the standard modifier stuff that this item don't make damage anymore
		
		me.benfah.bags.util.Attributes ab = new me.benfah.bags.util.Attributes(stack);
		ab.add(me.benfah.bags.util.Attributes.Attribute.newBuilder().name("AttackSpeed").type(me.benfah.bags.util.Attributes.AttributeType.GENERIC_ATTACK_SPEED).amount(0).build());
		ab.add(me.benfah.bags.util.Attributes.Attribute.newBuilder().name("AttackDamage").type(me.benfah.bags.util.Attributes.AttributeType.GENERIC_ATTACK_DAMAGE).amount(0).build());
		ItemStack stack2 = ab.getStack();
		stack2 = me.benfah.bags.util.Attributes.hideFlags(stack2, 38);
		return stack2;
	}
	public void setRecipeInConfig(String s, Material m1, Material m2, Material m3, Material m4, Material m5, Material m6, Material m7, Material m8, Material m9)
	{
		if (!Bags.recipeCfg.contains("recipes." + s + ".1")) Bags.recipeCfg.set("recipes." + s + ".1", m1.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".2")) Bags.recipeCfg.set("recipes." + s + ".2", m2.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".3")) Bags.recipeCfg.set("recipes." + s + ".3", m3.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".4")) Bags.recipeCfg.set("recipes." + s + ".4", m4.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".5")) Bags.recipeCfg.set("recipes." + s + ".5", m5.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".6")) Bags.recipeCfg.set("recipes." + s + ".6", m6.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".7")) Bags.recipeCfg.set("recipes." + s + ".7", m7.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".8")) Bags.recipeCfg.set("recipes." + s + ".8", m8.toString());
		if (!Bags.recipeCfg.contains("recipes." + s + ".9")) Bags.recipeCfg.set("recipes." + s + ".9", m9.toString());
		try {
			Bags.recipeCfg.save(Bags.recipeCfgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
