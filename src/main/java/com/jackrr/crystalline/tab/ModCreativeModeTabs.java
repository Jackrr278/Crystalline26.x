package com.jackrr.crystalline.tab;

import com.jackrr.crystalline.Crystalline;
import com.jackrr.crystalline.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Crystalline.MODID);

    public static final Supplier<CreativeModeTab> CRYSTALLINE_ITEM_TAB = CREATIVE_MODE_TABS.register("crystalline_item_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY_GEMSTONE.get()))
                    .title(Component.translatable("creativetab.jackrr.crystalline_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.RUBY_GEMSTONE);
                    })



                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
