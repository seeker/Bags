package me.benfah.bags.util;

import net.minecraft.server.v1_9_R1.BlockPosition;
import net.minecraft.server.v1_9_R1.ContainerAnvil;
import net.minecraft.server.v1_9_R1.EntityHuman;

public class AnvilContainer extends ContainerAnvil {
 
    public AnvilContainer(EntityHuman entity) {
        super(entity.inventory, entity.world, new BlockPosition(0,0,0), entity);
    }
 
    @Override
    public boolean a(EntityHuman entityhuman) {
        return true;
    }
}