package com.jackrr.crystalline.client;

import com.jackrr.crystalline.Crystalline;
import com.jackrr.crystalline.entity.ModEntities;
import com.jackrr.crystalline.entity.client.ModelRuby;
import com.jackrr.crystalline.entity.client.render.RendererRuby;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Crystalline.MODID)
public class Client {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                ModelRuby.LAYER_LOCATION,
                ModelRuby::createBodyLayer
        );
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                ModEntities.RUBY.get(),
                RendererRuby::new
        );
    }
}