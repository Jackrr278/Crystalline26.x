package com.jackrr.crystalline.entity;

import com.jackrr.crystalline.entity.custom.EntityRuby;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = "crystalline")
public class ModEntityAttributes {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(
                ModEntities.RUBY.get(),
                EntityRuby.createAttributes().build()
        );
    }
}