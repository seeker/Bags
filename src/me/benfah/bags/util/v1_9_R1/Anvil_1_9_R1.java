package me.benfah.bags.util.v1_9_R1;

import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R1.BlockPosition;
import net.minecraft.server.v1_9_R1.ChatMessage;
import net.minecraft.server.v1_9_R1.ContainerAnvil;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityPlayer;
import net.minecraft.server.v1_9_R1.PacketPlayOutOpenWindow;

public class Anvil_1_9_R1 extends ContainerAnvil {

   public Anvil_1_9_R1(EntityHuman entityHuman) {
      super(entityHuman.inventory, entityHuman.world, new BlockPosition(entityHuman.locX, entityHuman.locY, entityHuman.locZ), entityHuman);
   }

   public boolean a(EntityHuman entityHuman) {
      return true;
   }
   
   public void openAnvil(Player player) {
      EntityPlayer ep = ((CraftPlayer)player).getHandle();
      Anvil_1_9_R1 anvil = new Anvil_1_9_R1(ep);
      int cID = ep.nextContainerCounter();
      ep.playerConnection.sendPacket(new PacketPlayOutOpenWindow(cID, "minecraft:anvil", new ChatMessage("Anvil", new Object[0]), 0));
      ep.activeContainer = anvil;
      ep.activeContainer.windowId = cID;
      //ep.activeContainer.addSlotListener(ep);
   }
   
   
   
   

	
}
