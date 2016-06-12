package me.benfah.bags.util;

import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.ContainerAnvil;
import net.minecraft.server.v1_9_R2.EntityHuman;

public class AnvilContainer extends ContainerAnvil {
 
    public AnvilContainer(EntityHuman entity) {
        super(entity.inventory, entity.world, new BlockPosition(0,0,0), entity);
    }
 
    @Override
    public boolean a(EntityHuman entityhuman) {
        return true;
    }
}