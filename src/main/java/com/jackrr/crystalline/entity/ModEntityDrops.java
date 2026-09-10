package com.jackrr.crystalline.entity;

import com.jackrr.crystalline.entity.custom.EntityRuby;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

import static com.jackrr.crystalline.data.ModDataComponents.GEM_UUID;
import static com.jackrr.crystalline.item.ModItems.RUBY_GEMSTONE;

@EventBusSubscriber(modid = "crystalline")
public class ModEntityDrops {
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof EntityRuby ruby) {
            ItemStack gemstone = new ItemStack(RUBY_GEMSTONE.get());
            gemstone.set(GEM_UUID, ruby.getGemUUID());

            event.getDrops().add(
                    new ItemEntity(
                            ruby.level(),
                            ruby.getX(),
                            ruby.getY(),
                            ruby.getZ(),
                            gemstone
                    )
            );
        }
    }
}
