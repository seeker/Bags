package me.benfah.bags.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.benfah.bags.main.Bags;

public class Util {

	public static String standardLink = "https://www.dropbox.com/s/kllx5y7aqv5x317/Bags2.zip?dl=1";
	
	public static boolean isUnbreakableAndHasDamage(ItemStack stack, short damage)
	{
		if(stack.getItemMeta().spigot().isUnbreakable())
		if(stack.getDurability() == damage)
		return true;
		return false;
	}
	
	public static void sendRequest(Player p)
	{
		if(Bags.cfg.getBoolean("custom-resourcepack"))
		{
			p.setResourcePack(Bags.cfg.getString("custom-resourcepack-link"));
		}
		else
		p.setResourcePack(standardLink);
	}
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
	    return false;
	}
	
	private static Class<?> getNMSClass(String nmsClassString) throws ClassNotFoundException {
	    String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + ".";
	    String name = "net.minecraft.server." + version + nmsClassString;
	    Class<?> nmsClass = Class.forName(name);
	    return nmsClass;
	}
	
	public static Object getConnection(Player player) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
	    Method getHandle = player.getClass().getMethod("getHandle");
	    Object nmsPlayer = getHandle.invoke(player);
	    Field conField = nmsPlayer.getClass().getField("playerConnection");
	    Object con = conField.get(nmsPlayer);
	    return con;
	}
	
}
