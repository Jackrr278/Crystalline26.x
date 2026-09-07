package com.jackrr.crystalline.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

import static com.jackrr.crystalline.data.ModDataComponents.GEM_UUID;

public class ItemGem extends Item {
    public ItemGem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        UUID gemUUID;

        if(stack.has(GEM_UUID)) {
            gemUUID = stack.get(GEM_UUID);
            System.out.println(gemUUID);
        }
        else{
            gemUUID = UUID.randomUUID();

            stack.set(GEM_UUID, gemUUID);
            System.out.println(gemUUID);
        }


        return super.use(level, player, hand);
    }
}
