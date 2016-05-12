package me.benfah.bags.util.v1_9_R2;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.ChatMessage;
import net.minecraft.server.v1_9_R2.ContainerAnvil;
import net.minecraft.server.v1_9_R2.EntityHuman;
import net.minecraft.server.v1_9_R2.EntityPlayer;
import net.minecraft.server.v1_9_R2.PacketPlayOutOpenWindow;

public class Anvil extends ContainerAnvil{

   public Anvil(EntityHuman entityHuman) {
      super(entityHuman.inventory, entityHuman.world, new BlockPosition(entityHuman.locX, entityHuman.locY, entityHuman.locZ), entityHuman);
   }

   public boolean a(EntityHuman entityHuman) {
      return true;
   }
   
   public static void openAnvil(Player player) {
	  
	  
      EntityPlayer ep = ((CraftPlayer)player).getHandle();
      Anvil anvil = new Anvil(ep);
      int cID = ep.nextContainerCounter();
      ep.playerConnection.sendPacket(new PacketPlayOutOpenWindow(cID, "minecraft:anvil", new ChatMessage("Anvil", new Object[0]), 0));
      ep.activeContainer = anvil;
      ep.activeContainer.windowId = cID;
   }
   
   
   
   

	
}
