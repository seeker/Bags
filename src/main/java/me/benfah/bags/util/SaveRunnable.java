package me.benfah.bags.util;

import me.benfah.bags.main.Bags;

public class SaveRunnable implements Runnable{

	@Override
	public void run()
	{
		Bags.bm.shutdown();
		
	}
}
