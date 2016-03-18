package me.benfah.bags.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.benfah.bags.main.Bags;

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
			Inventory inv = Bukkit.createInventory(null, size, "Bag");
			inv.setContents(vf);
			bag.put(k, new Object[]{inv,size});
		}
		}
		
		
		
		
		
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
				new File(inst.getDataFolder(), "saveb64.dat").createNewFile();
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
