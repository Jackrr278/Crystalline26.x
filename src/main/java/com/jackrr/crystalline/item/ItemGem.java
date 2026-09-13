package com.jackrr.crystalline.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import com.jackrr.crystalline.entity.ModEntities;
import com.jackrr.crystalline.entity.custom.EntityRuby;

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

        EntityRuby ruby = new EntityRuby(ModEntities.RUBY.get(), level);
        ruby.setGemUUID(gemUUID);
        ruby.setCustomName(Component.literal(gemUUID.toString()));
        ruby.setPos(player.position());

        level.addFreshEntity(ruby);
        stack.shrink(1);


        return super.use(level, player, hand);
    }
}
