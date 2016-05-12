package me.benfah.bags.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.benfah.bags.main.Bags;
import me.benfah.bags.translation.Translation;

public class BagManager
{
	
	public static HashMap<Integer, Object[]> bag = new HashMap<Integer, Object[]>();
	public static HashMap<Integer, String[]> bag64 = new HashMap<Integer, String[]>();

	public Bags inst;
	public BagManager(Bags instance)
	{
		
		this.inst = instance;
		
		
	}
	
	public void init() throws Exception
	{
		if(new File(inst.getDataFolder(), "saveb64.dat").exists())
		{
		bag64 = load(new File(inst.getDataFolder(), "saveb64.dat"));
		Iterator<Integer> itk = bag64.keySet().iterator();
		Iterator<String[]> itv = bag64.values().iterator();
		
		while(itk.hasNext() && itv.hasNext())
		{
			int k = itk.next();
			String[] v = itv.next();
			ItemStack[] vf = InventorySerializer.itemStackArrayFromBase64(v[0]);
			int size = (Integer) InventorySerializer.fromBase64Obj(v[1]);
			Inventory inv = Bukkit.createInventory(null, size, Translation.bag_inventory);
			inv.setContents(vf);
			bag.put(k, new Object[]{inv,size});
		}
		}
		
		
		
		
		
	}
	
	
	public static Inventory getInventory(int id)
	{
		Object[] obj = bag.get(id);
		Inventory oldInv = (Inventory) obj[0];
		Inventory inv = Bukkit.createInventory(null, (Integer) obj[1], Translation.bag_inventory);
		inv.setContents(oldInv.getContents());
		obj[0] = inv;
		return inv;
	}
	
	public static <T extends Object> void save(T obj, File path) throws Exception
    {
       
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }
 
    public static <T extends Object> T load(File path) throws Exception
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        T result = (T)ois.readObject();
        ois.close();
        return result;
    }
	
	
	public void shutdown()
	{
		if(!new File(inst.getDataFolder(), "saveb64.dat").exists())
		{
			try {
				inst.getDataFolder().mkdirs();
				File f = new File(inst.getDataFolder(), "saveb64.dat");
				
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		bag64.clear();
		
		Iterator<Integer> itk = bag.keySet().iterator();
		Iterator<Object[]> itv = bag.values().iterator();
		
		while(itk.hasNext() && itv.hasNext())
		{
			int k = itk.next();
			Object[] v = itv.next();
			String vf = InventorySerializer.itemStackArrayToBase64(((Inventory) v[0]).getContents());
			String size = InventorySerializer.toBase64Obj(v[1]);
			bag64.put(k, new String[]{vf, size});
			
		}
		
		try {
			save(bag64, new File(inst.getDataFolder(), "saveb64.dat"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
