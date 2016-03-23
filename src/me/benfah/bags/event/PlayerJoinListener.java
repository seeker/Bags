package me.benfah.bags.event;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import me.benfah.bags.main.Bags;

public class PlayerJoinListener implements Listener{

	ArrayList<Player> tl = new ArrayList<Player	>();
	
	@EventHandler
	public void onJoin(PlayerMoveEvent e)
	{
		if(!tl.contains(e.getPlayer()))
		{
			if(e.getPlayer().hasPermission(new Permission("bag.resource",PermissionDefault.NOT_OP)))
			{
				e.getPlayer().setResourcePack("https://www.dropbox.com/s/dc2bpx4w0loavuo/Bags.zip?dl=1");
			}
		}
		
		tl.add(e.getPlayer());
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		tl.remove(e.getPlayer());
		
		
	}
	
}
