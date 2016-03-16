package me.benfah.bags.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

public class InventorySerializer {
	
	
	 public static String[] playerInventoryToBase64(PlayerInventory playerInventory) throws IllegalStateException
	 {
	    	String content = toBase64(playerInventory);
	    	String armor = itemStackArrayToBase64(playerInventory.getArmorContents());
	    	
	    	return new String[] { content, armor };
	 }
	 public static String itemStackArrayToBase64(ItemStack[] items) throws IllegalStateException
	 {
	    	try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
	            
	            dataOutput.writeInt(items.length);
	            
	            for (int i = 0; i < items.length; i++) {
	                dataOutput.writeObject(items[i]);
	            }
	            
	            dataOutput.close();
	            return Base64Coder.encodeLines(outputStream.toByteArray());
	        } catch (Exception e) {
	            throw new IllegalStateException("Unable to save item stacks.", e);
	        }
	  }
	 
	 public static String toBase64(Inventory inventory) throws IllegalStateException
	 {
	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
	            
	            dataOutput.writeInt(inventory.getSize());
	            
	            for (int i = 0; i < inventory.getSize(); i++) {
	                dataOutput.writeObject(inventory.getItem(i));
	            }
	            
	            dataOutput.close();
	            return Base64Coder.encodeLines(outputStream.toByteArray());
	        } catch (Exception e) {
	            throw new IllegalStateException("Unable to save item stacks.", e);
	        }
	 }
	 public static String toBase64Obj(Object obj)
	 {
		 try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
	            
	            dataOutput.writeObject(obj);
	            
	           
	            
	            dataOutput.close();
	            return Base64Coder.encodeLines(outputStream.toByteArray());
	        } catch (Exception e) {
	            throw new IllegalStateException("Unable to save obj.", e);
	        }		 
		 
		 
	 }
	 public static Object fromBase64Obj(String data)
	 {
	        try {
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
	            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
	    
	            Object obj = dataInput.readObject();
	            
	            dataInput.close();
	            return obj;
	        } catch (Exception e) {
	            return null;
	        }
	 }
	 public static Inventory fromBase64(String data) throws IOException
	 {
	        try {
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
	            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
	            Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());
	    
	            for (int i = 0; i < inventory.getSize(); i++) {
	                inventory.setItem(i, (ItemStack) dataInput.readObject());
	            }
	            
	            dataInput.close();
	            return inventory;
	        } catch (ClassNotFoundException e) {
	            throw new IOException("Unable to decode class type.", e);
	        }
	 }
	 public static ItemStack[] itemStackArrayFromBase64(String data) throws IOException {
	    	try {
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
	            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
	            ItemStack[] items = new ItemStack[dataInput.readInt()];
	    
	            for (int i = 0; i < items.length; i++) {
	            	items[i] = (ItemStack) dataInput.readObject();
	            }
	            
	            dataInput.close();
	            return items;
	        } catch (ClassNotFoundException e) {
	            throw new IOException("Unable to decode class type.", e);
	        }
	 }
}
	
