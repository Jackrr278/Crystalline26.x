package com.jackrr.crystalline.entity;

import com.jackrr.crystalline.Crystalline;
import com.jackrr.crystalline.entity.custom.EntityRuby;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Crystalline.MODID);

    public static final Supplier<EntityType<EntityRuby>> RUBY =
            ENTITY_TYPES.register("ruby", () -> EntityType.Builder.of(EntityRuby::new, MobCategory.CREATURE)
                            .sized(0.75f, 1.8f).build(
                                    ResourceKey.create(
                                            Registries.ENTITY_TYPE,
                                            Identifier.fromNamespaceAndPath(Crystalline.MODID, "ruby")
                                    )
                            )
                    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
