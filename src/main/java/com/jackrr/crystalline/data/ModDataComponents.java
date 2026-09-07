package com.jackrr.crystalline.data;

import com.jackrr.crystalline.Crystalline;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.UUID;

public class ModDataComponents {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(
                    Registries.DATA_COMPONENT_TYPE,
                    Crystalline.MODID
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> GEM_UUID =
        DATA_COMPONENTS.registerComponentType(
          "gem_uuid",
                builder -> builder.persistent(UUIDUtil.CODEC)
        );


    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }


}
